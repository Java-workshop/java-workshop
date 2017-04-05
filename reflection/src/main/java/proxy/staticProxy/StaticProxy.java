package proxy.staticProxy;

public class StaticProxy implements SimpleInterface {
    SimpleInterface simpleInterface;

    public StaticProxy(final SimpleInterface simpleInterface) {
        this.simpleInterface = simpleInterface;
    }

    @Override
    public void printOutInput(final String s) {
        System.out.println("before...");
        simpleInterface.printOutInput(s);
        System.out.println("after...");
    }
}
