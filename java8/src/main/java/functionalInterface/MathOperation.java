package functionalInterface;

/**
 * Created by fjiang on 2/6/17.
 */
@FunctionalInterface
public interface MathOperation<T, R> {
    R operate(T a, T b);

    default void sayHi(String s1) {
        System.out.println("HI");
    }
}
