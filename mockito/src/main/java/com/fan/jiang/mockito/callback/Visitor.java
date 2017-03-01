package com.fan.jiang.mockito.callback;

/**
 * Created by fjiang on 2/28/17.
 */
public class Visitor {
    public void visit(Notifier notifier) {
        notifier.giveASignal();
    }
}
