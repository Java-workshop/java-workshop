package customTest.tests;

import customTest.annotations.Test;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fjiang on 7/12/17.
 */
public class Runtests {
    public static List<Class<?>> findClassesInPackage(final String packageName) throws ClassNotFoundException {
        final String replaced = packageName.replace(".", "/");
        final File dir = new File("reflection/src/main/java/" + replaced);
        final String[] dirList = dir.list();

        final List<Class<?>> classes = new ArrayList<>();
        for (String file : dirList) {
            if (file.endsWith(".java")) {
                classes.add(Class.forName(packageName + "." + file.replace(".java", "")));
            }else{
                classes.addAll(findClassesInPackage(packageName + "." + file));
            }
        }

        return classes;
    }

    public static void runTest(Class clazz) throws IllegalAccessException, InstantiationException {
        final Object clazzInstance = clazz.newInstance();
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        Object result = null;
        int tests = 0;
        int successful = 0;
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                ++tests;
                try {
                    result = method.invoke(clazz);
                    successful++;
                } catch (InvocationTargetException e) {
                    System.out.printf("The underlying method %s throws an Exception %s%n", method.getName(), e.getClass());
                } catch (Exception ex) {
                    System.out.printf("The underlying method %s throws an Exception %s%n", method.getName(), ex.getClass());
                }
            }
        }

        System.out.printf("In the class %s there are %d tests and %d are successful and %d are failed%n", clazz.getName(), tests, successful, tests-successful);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final List<Class<?>> classesInPackage = Runtests.findClassesInPackage("customTest.tests");
        for (Class clazz : classesInPackage) {
            runTest(clazz);
        }

    }
}
