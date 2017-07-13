package basics;

import customTest.annotations.RuntimeRetention;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fjiang on 4/5/17.
 */
public class ReflectionBasics {
    public static void main(String[] args) throws NoSuchMethodException {
        final Class<Integer> integerClass = int.class;
        final Class<Person> personClass = Person.class;
        System.out.println(integerClass);
        final Class<Void> voidClass = void.class;
        System.out.println(voidClass);
        String string = new String("");
        string.getClass();
        try {
            final Class<?> aClass = Class.forName("java.lang.String");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        try {
            final Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        //Modifiers
        System.out.println("***************Modifiers*************");
        final int modifiers = Person.class.getModifiers();
        final boolean aPublic = Modifier.isPublic(modifiers);

        //Package
        final Package aPackage = Person.class.getPackage();
        System.out.println(aPackage);

        //Superclass and Interfaces
        System.out.println("**************Superclass&Interfaces**********");
        final Class<?>[] interfaces = Person.class.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        //Construcots
        System.out.println("*************Constructors**********");
        Person.class.getConstructors();
        try {
            final Constructor<Person> constructor =
                Person.class.getConstructor(null);
            final Person person = constructor.newInstance();
            System.out.println(person);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

        Person.class.getConstructor(String.class, int.class, boolean.class, String[].class);

        //Fields
        System.out.println("***************Fields****************");
        final Field[] fields = Person.class.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field));
        final Field[] declaredFields = Person.class.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
        try {
            Person person = new Person();
            final Field age = Person.class.getDeclaredField("age");
            age.setAccessible(true);
            age.set(person, 2);
            System.out.println(person);
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }

        //Annotations
        System.out.println("***************Annotations****************");
        @RuntimeRetention(value = "runtime", mode="dummy")
        class InnerClass {
        }
        final Annotation[] annotations = InnerClass.class.getAnnotations();
        Arrays.stream(annotations).map(Annotation::annotationType).forEach(System.out::println);
        Arrays.stream(annotations).filter(annotation -> annotation instanceof RuntimeRetention).forEach(annotation -> {
            System.out.println(((RuntimeRetention)annotation).value());
            if (((RuntimeRetention) annotation).mode().equals("dummy")) {
                System.out.println("By dummy mode");
            }
        });

        //Generics
        System.out.println("***************Generics****************");
        final Class<MyGenericsClass> myGenericsClassClass = MyGenericsClass.class;
        final Type returnType = myGenericsClassClass.getMethod("getList", null).getGenericReturnType();
        if (returnType instanceof ParameterizedType) {

            final ParameterizedType parameterizedType = (ParameterizedType) returnType;
            Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(System.out::println);
        }
        Arrays.stream(((ParameterizedType) MySubGenericsClass.class.getGenericSuperclass()).getActualTypeArguments()).forEach(System.out::println);

        String DURATIONS_PATTERN = "^\\{((\\d\\s*)+,{0,1})*(\\d\\s*)+\\}$";
        String test = "{1,2  ,3 }";
        System.out.println(test.matches(DURATIONS_PATTERN));

    }

    public static List<Class<?>> getAllInterfaces(Class clazz) {
        List<Class<?>> allInterfaces = new ArrayList<>();
        while (!clazz.equals(Object.class)) {
            final Class<?>[] interfaces = clazz.getInterfaces();
            allInterfaces.addAll(Arrays.asList(interfaces));
            clazz = clazz.getSuperclass();
        }
        return allInterfaces;
    }
}
