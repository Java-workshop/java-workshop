package com.fan.jiang.mockito.callback;

/**
 * Created by fjiang on 2/28/17.
 */
public class Dog implements Notifier {
    @Override
    public void giveASignal() {
        System.out.println("Wow!Wow!");
    }
}
