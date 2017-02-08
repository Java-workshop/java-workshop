package builtInFunctionalInterface;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by fjiang on 2/8/17.
 */

class DigitsPasswordSupplier implements Supplier<String>{
    private int length;
    private static String CHARS_ALLOWED = "0123456789";

    public DigitsPasswordSupplier(int length) {
        this.length = length;
    }

    @Override
    public String get() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i=0;i<length;i++) {
            password.append(CHARS_ALLOWED.charAt(random.nextInt(CHARS_ALLOWED.length())));
        }
        return password.toString();
    }
}

class WordsPasswordSupplier implements Supplier<String>{
    private int length;
    private static String CHARS_ALLOWED = "abcdefg";

    public WordsPasswordSupplier(int length) {
        this.length = length;
    }

    @Override
    public String get() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i=0;i<length;i++) {
            password.append(CHARS_ALLOWED.charAt(random.nextInt(CHARS_ALLOWED.length())));
        }
        return password.toString();
    }
}

public class BuiltInFunctionalInterfaceTest {
    public static void main(String[] args) {
        Predicate<Integer> even = a -> a % 2 == 0;
        Predicate<Integer> negate = even.negate();
        System.out.println(negate.test(5));

        Supplier<String> passwordSupplier = new DigitsPasswordSupplier(10);
        System.out.println(passwordSupplier.get());


        
    }
}
