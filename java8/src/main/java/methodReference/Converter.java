package methodReference;

/**
 * Created by fjiang on 2/7/17.
 */
@FunctionalInterface
public interface Converter<F, R> {
    R convert(F from);
}
