package lesson7;

import lesson7.annotation.AfterSuite;
import lesson7.annotation.BeforeSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public TestClass () {
    }
    static void start (Object aClass) {
        Method before = null;
        Method after = null;
        Method[] methods = aClass.getClass().getDeclaredMethods();
        List<Method> methodsTest = new ArrayList<>();
        List<Method> methodsTestResult = new ArrayList<>();

        for (int i = 0; i < methods.length; i++) {

            if (methods[i].getAnnotation(BeforeSuite.class) != null && before == null) {
                before = methods[i];
            }
            else if  (methods[i].getAnnotation(lesson7.annotation.Test.class) != null) {
                    methodsTest.add(methods[i]);
                            }
            else if (methods[i].getAnnotation(AfterSuite.class) != null && after == null) {
                    after= methods[i];
                }
           else {throw new RuntimeException("Second annotation BeforeTest/AfterTest in test-class");}
        }
        for (int i = 1; i <=10 ; i++) {
            for (int j = 0; j < methodsTest.size() ; j++) {
                if (methodsTest.get(j).getAnnotation(lesson7.annotation.Test.class).priority() == i){
                    methodsTestResult.add(methodsTest.get(j));
                }
            }
        }
        methodsTestResult.add(0, before);
        methodsTestResult.add(methodsTestResult.size(), after);
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


