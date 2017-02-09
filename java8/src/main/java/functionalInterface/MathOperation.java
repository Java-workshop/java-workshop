package functionalInterface;

/**
 * Created by fjiang on 2/6/17.
 */
@FunctionalInterface
public interface MathOperation<T, R, C> {
    R operate(T a, T b, C c);

    default void sayHi(String s1) {
        System.out.println("HI");
    }
}
