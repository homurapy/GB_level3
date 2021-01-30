package lesson7;

import lesson7.annotation.AfterSuite;
import lesson7.annotation.BeforeSuite;
import lesson7.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClass {
    public TestClass () {
    }
    static void start (Object aClass) {
        Method[] methods = aClass.getClass().getDeclaredMethods();
        executionTest(preparationTest(methods), aClass);
    }
    private static List<Method> preparationTest (Method[] methods){
        Method before = null;
        Method after = null;
        List<Method> methodsTest = new ArrayList<>();
        for (int i = 0; i < methods.length; i++) {

            if (methods[i].getAnnotation(BeforeSuite.class) != null && before == null) {
                before = methods[i];
            } else if (methods[i].getAnnotation(lesson7.annotation.Test.class) != null) {
                methodsTest.add(methods[i]);
//                System.out.println(methods[i].isAnnotationPresent(Test.class));
            } else if (methods[i].getAnnotation(AfterSuite.class) != null && after == null) {
                after = methods[i];
            } else {
                throw new RuntimeException("Second annotation BeforeTest/AfterTest in test-class");
            }
        }
        Collections.sort(methodsTest, new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
                int r1 = o1.getAnnotation(Test.class).priority();
                int r2 = o2.getAnnotation(Test.class).priority();
                return r1-r2;
            }
        });
        if (before != null){
            methodsTest.add(0, before);
        }
        if (after != null) {
            methodsTest.add(methodsTest.size(), after);
        }

        return methodsTest;
    }
    static void executionTest (List<Method> methodsTestResult, Object aClass){
        methodsTestResult.forEach(t-> {
            try {
                t.setAccessible(true);
                t.invoke(aClass);
                t.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}


