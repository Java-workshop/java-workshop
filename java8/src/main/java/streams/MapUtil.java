package streams;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

/**
 * Created by fjiang on 2/2/17.
 */
public class MapUtil {

    public static String getQueryStringWithIterator(final Map<String, String> queryParams) {
        if (queryParams == null || queryParams.size() < 1) {
            return "";
        }

        Iterator<Map.Entry<String, String>> entryIterator = queryParams.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            builder.append(entry.getKey());
            builder.append("=");
            builder.append(entry.getValue());
            builder.append(";");
        }

        if (builder.charAt(builder.length() - 1) == ';') {
            return builder.substring(0, builder.length() - 1);
        }else{
            return builder.toString();
        }
    }

    public static String getQueryStringWithFor(Map<String, String> queryParams) {
        if (queryParams == null || queryParams.size() < 1) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            builder.append(entry.getKey());
            builder.append("=");
            builder.append(entry.getValue());
            builder.append(";");
        }

        if (builder.charAt(builder.length() - 1) == ';') {
            return builder.substring(0, builder.length() - 1);
        }else{
            return builder.toString();
        }
    }

    public static Optional<String> getQueryStringWithStream(Map<String, String> queryParams) {
        if (queryParams == null || queryParams.size() < 1) {
            return Optional.empty();
        }

        Set<String> keySet = queryParams.keySet();
        Optional<String> reduce = keySet.stream()
                .map(k -> k + "=" + queryParams.get(k))
                .reduce((s1, s2) -> s1 + ";"+s2 );
        return reduce;

    }

    public static void main(String[] args) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "fan");
        queryParams.put("familyName", "jiang");
        queryParams.put("age", "18");

        System.out.println(MapUtil.getQueryStringWithFor(queryParams));
        System.out.println(MapUtil.getQueryStringWithIterator(queryParams));

        Optional<String> queryStringWithStream = MapUtil.getQueryStringWithStream(queryParams);
        System.out.println(queryStringWithStream.orElseThrow(RuntimeException::new));

        List<String> animals = Arrays.asList("dog", "duck", "pig", "cat", "mouse", "tiger");
        animals.stream()
                .filter(s -> s.startsWith("d"))
                .map(s -> "I like " + s)
                .reduce((s1, s2) -> s1 + ";" + s2);

        List<Integer> integers = Arrays.asList(1, 2, 4, 3, 12, 6, 5);

        IntSummaryStatistics intSummaryStatistics = integers.stream()
                .mapToInt(s -> s)
                .summaryStatistics();
        double average = intSummaryStatistics.getAverage();
        System.out.println(average);

    }
}
