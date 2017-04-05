package com.fan.jiang.mockito.entities.exceptions;

/**
 * Created by fjiang on 3/1/17.
 */
public class InvalidAddressException extends RuntimeException {
    public InvalidAddressException() {
    }

    public InvalidAddressException(final String message) {
        super(message);
    }

    public InvalidAddressException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
