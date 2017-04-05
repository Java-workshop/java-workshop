package proxy.staticProxy;

public class Test {
    public static void main(String[] args) {
        SimpleInterface simple = new SimpleImpl();
        StaticProxy proxy = new StaticProxy(simple);
        proxy.printOutInput("proxy");
    }
}
