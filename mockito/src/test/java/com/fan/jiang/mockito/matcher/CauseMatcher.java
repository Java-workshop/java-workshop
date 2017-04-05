package com.fan.jiang.mockito.matcher;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by fjiang on 3/1/17.
 */
public class CauseMatcher extends TypeSafeMatcher<Throwable>{
    private Class<? extends Throwable> type;
    private String message;

    public CauseMatcher(final Class<? extends Throwable> type, final String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    protected boolean matchesSafely(final Throwable throwable) {
        return throwable.getClass().isAssignableFrom(type) & throwable.getMessage().contains(message);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("expected type")
            .appendValue(type)
            .appendText(" with a message")
            .appendValue(message);
    }
}
