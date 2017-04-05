package customTest.tests;

import customTest.annotations.Test;

public class PersonTest {

    @Test
    private void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public static void test3() {
        System.out.println("test3");
    }

    @Test
    public void test4() {
        System.out.println("test4");
        throw new RuntimeException("From test4");
    }

    public void test5() {
        System.out.println("test5");
    }
}
