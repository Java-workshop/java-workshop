package com.fan.jiang.mockito.entities.exceptions;

/**
 * Created by fjiang on 3/1/17.
 */
public class InvalidStreetException extends RuntimeException {

    public InvalidStreetException(final String s) {
        super(s);
    }

    public InvalidStreetException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidStreetException() {
    }
}
