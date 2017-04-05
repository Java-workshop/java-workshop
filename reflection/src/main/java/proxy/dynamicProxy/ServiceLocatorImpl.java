package proxy.dynamicProxy;


public class ServiceLocatorImpl implements ServiceLocator{
    @Override
    public void login() {
        System.out.println("login");
    }

    @Override
    public void logout() {
        System.out.println("logout");
    }
}
