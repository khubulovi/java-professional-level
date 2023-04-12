package lesson7;


import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestingClass {

    public static <T> void start(Class<T> cls) {
        performTests(cls);
    }

    private static <T> void performTests(Class<T> cls) throws RuntimeException {
        TestingClass testingObject;
        try {
            testingObject = (TestingClass) cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Method beforeMethod = null, afterMethod = null;
        Method[] methods = cls.getMethods();
        List<MethodPriority> testingMethods = new ArrayList<>();

        for (Method method : methods)
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null) {
                    throw new RuntimeException("More than one @BeforeSuite annotation found");
                }
                beforeMethod = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null) {
                    throw new RuntimeException("More than one @AfterSuite annotation found");
                }
                afterMethod = method;
            } else if (method.getAnnotation(Test.class) != null) {
                Test annotationTst = method.getAnnotation(Test.class);
                testingMethods.add(new MethodPriority(method, annotationTst.priority()));
            }

        testingMethods.sort(Comparator.comparing(MethodPriority::getPriority));

        try {
            if (beforeMethod != null) {
                beforeMethod.invoke(testingObject);
            }
            if (afterMethod != null) {
                afterMethod.invoke(testingObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeAll() {
        System.out.println("The method is executed before all tests");
    }

    @Test(priority = 3)
    public void thirdTest() {
        System.out.println("Call test №3");
    }

    @Test(priority = 2)
    public void secondTest() {
        System.out.println("Call test №2");
    }

    @Test(priority = 5)
    public void firstTest() {
        System.out.println("Call test №1");
    }

    @Test(priority = 1)
    public void fourthTest() {
        System.out.println("Call test №4");
    }

    @Test(priority = 7)
    public void fiveTest() {
        System.out.println("Call test №5");
    }

    @AfterSuite
    public void afterAll() {
        System.out.println("The method is executed after all tests");
    }
}