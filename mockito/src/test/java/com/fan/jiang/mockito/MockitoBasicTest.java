package com.fan.jiang.mockito;

import com.fan.jiang.mockito.entities.Address;
import com.fan.jiang.mockito.entities.exceptions.InvalidAddressException;
import com.fan.jiang.mockito.entities.exceptions.InvalidStreetException;
import com.fan.jiang.mockito.matcher.CauseMatcher;
import java.util.ArrayList;
import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by fjiang on 3/1/17.
 */
public class MockitoBasicTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDivisionWithException() {
        try {
            int i = 1 / 0;
            fail();
        } catch (ArithmeticException ex) {
            assertThat(ex.getMessage(), is("/ by zero"));
        }
    }

    @Test
    public void stubbing() {
        ArrayList mock = mock(ArrayList.class);

        when(mock.get(0)).thenReturn("hi");
        when(mock.get(1)).thenReturn("You");
        when(mock.get(2)).thenThrow(new RuntimeException());
        expectedException.expect(RuntimeException.class);

        System.out.println(mock.get(0));;
        System.out.println(mock.get(1));
        System.out.println(mock.get(5));
        System.out.println(mock.get(2));
    }

    @Test
    public void argumentMatcher() {
        ArrayList mock = mock(ArrayList.class);

        when(mock.add(argThat((String s) -> s.length() > 3))).thenReturn(true);
        when(mock.get(anyInt())).thenReturn("Element");

        System.out.println(mock.add("hi"));
        System.out.println(mock.add("Longer"));
        System.out.println(mock.get(100));

    }

    @Test
    public void testVerify() {
        ArrayList mock = mock(ArrayList.class);

        mock.add("one");
        mock.add("two");
        mock.add("three");
        mock.add("three");

        verify(mock).add("one");
        verify(mock).add("two");
        verify(mock, times(2)).add("three");
        verify(mock, atLeast(2)).add("three");
    }

    @Test
    public void testExpectedException() {
        final Address add = mock(Address.class, CALLS_REAL_METHODS);
        add.setStreet("hi");

        expectedException.expect(InvalidAddressException.class);
        expectedException.expectCause(new CauseMatcher(InvalidStreetException.class, "too short"));

        add.checkAddress();

//        expectedException.expect(RuntimeException.class);
//        expectedException.expectCause(new CauseMatcher(IllegalStateException.class, "Illegal"));

//        try {
//            throw new RuntimeException("RuntimeException is thrown", new IllegalStateException("Illegal state"));
//        } catch (Exception ex) {
//            assert (ex instanceof RuntimeException);
//            assertTrue(ex instanceof RuntimeException);
//            assert ex.getCause() instanceof IllegalStateException;
//            assertThat(ex.getCause().getMessage(), StringContains.containsString("Illegal"));
//        }
    }


}
