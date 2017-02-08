package methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fjiang on 2/6/17.
 */
public class MethodReference {

    public static void main(String[] args) {
        Converter<String, Integer> convertToInt = Integer::valueOf;
        System.out.println(convertToInt.convert("123"));

        List<String> strings = Arrays.asList("Hi", "Harry");
        strings.forEach(s -> System.out.println(s+"1"));

    }
}
