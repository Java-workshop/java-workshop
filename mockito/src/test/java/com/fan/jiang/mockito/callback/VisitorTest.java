package com.fan.jiang.mockito.callback;

import org.junit.Test;
import static org.mockito.AdditionalAnswers.answerVoid;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Created by fjiang on 3/1/17.
 */
public class VisitorTest {
    /**
     * ${CLASS} can work.
     * @throws Exception If fails
     */
    @Test
    public void testVisit() throws Exception {
        Visitor visitor = mock(Visitor.class);
        Dog notifier = mock(Dog.class);


        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                ((Notifier)invocation.getArgument(0)).giveASignal();
                return null;
            }
        }).when(visitor).visit(notifier);

        doAnswer(answerVoid(argument ->{((Dog)argument).giveASignal();
            System.out.println("hi"); } )).when(visitor).visit(notifier);
        visitor.visit(notifier);

        verify(notifier).giveASignal();
    }

}
