package com.fan.jiang.mockito.callback;

/**
 * Created by fjiang on 2/28/17.
 */
public interface Notifier {
    public void giveASignal();

    default void sayHi() {
        System.out.println("hi");
    }
}
