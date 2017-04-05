package customTest.annotations;

public @interface ExceptionTest {
    Class<? extends Exception> value();
}
