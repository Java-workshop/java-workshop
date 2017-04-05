package proxy.dynamicProxy.exception;

public class ServiceCallException extends RuntimeException {
    public ServiceCallException() {
        super();
    }

    public ServiceCallException(final String message) {
        super(message);
    }

    public ServiceCallException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServiceCallException(final Throwable cause) {
        super(cause);
    }
}
