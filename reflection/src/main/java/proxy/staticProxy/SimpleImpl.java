package proxy.staticProxy;


public class SimpleImpl implements SimpleInterface{
    @Override
    public void printOutInput(final String s) {
        System.out.println(s);
    }
}
