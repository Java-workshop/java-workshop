package proxy.dynamic_proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Base64;

/**
 * Created by fjiang on 7/12/17.
 */
public class PersonProxy implements InvocationHandler{

    private Object object;

    private PersonProxy(final Object object) {
        this.object = object;
    }

    public static Object newInstance(Object object) {
        return Proxy.newProxyInstance(
            object.getClass().getClassLoader(),
            object.getClass().getInterfaces(),
            new PersonProxy(object)
        );
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        Object result = null;
        if (method.getName().equals("setPassword") && args.length == 1 && args[0] instanceof String) {
            final String s = Base64.getEncoder().encodeToString(((String) args[0]).getBytes());
            result = method.invoke(object, s);
        }else {
           result = method.invoke(object, args);
        }
        return result;
    }

    public static void main(String[] args) {
        final Person person = new PersonImpl();
        final Person encodedPerson = (Person)newInstance(person);
        encodedPerson.setPassword("jiang");
        System.out.println(person.getPassword());
    }
}
