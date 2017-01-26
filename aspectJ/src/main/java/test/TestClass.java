package test;

import annotations.LogInvocation;

/**
 * Created by fjiang on 1/25/17.
 */
public class TestClass {
    @LogInvocation(LogInvocation.LogLevel.DEBUG)
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args){
        TestClass testClass = new TestClass();
        testClass.test();
    }
}
