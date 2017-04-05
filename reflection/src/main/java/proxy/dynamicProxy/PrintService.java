package proxy.dynamicProxy;

public class PrintService implements Service{
    @Override
    public void doSomething() {
        System.out.println(this.getClass().getSimpleName());
    }
}
