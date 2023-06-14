package net.dmytro.homework19;
import net.dmytro.homework19.annotation.AfterSuit;
import net.dmytro.homework19.annotation.BeforeSuit;
import net.dmytro.homework19.annotation.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void start(Class<?> clas) throws Exception {
        Method afterSuit = null;
        Method beforeSuit = null;
        List<Method> methodsList = new ArrayList<>();
        Object testInstance = clas.getDeclaredConstructor().newInstance();


        for (Method method : clas.getDeclaredMethods()){
            if (method.isAnnotationPresent(BeforeSuit.class)){
                if (beforeSuit == null){
                    beforeSuit = method;
                }else {
                    throw new RuntimeException("BeforeSuite method already exists!");
                }
            } else if (method.isAnnotationPresent(AfterSuit.class)) {
                if (afterSuit == null){
                    afterSuit= method;
                }else {
                    throw new RuntimeException("AfterSuit method already exists!");
                }
            }else if (method.isAnnotationPresent(Test.class)){
                methodsList.add(method);
            }
        }

        methodsList.sort((m1, m2) -> Integer.compare(m1.getAnnotation(Test.class).priority(),
                m2.getAnnotation(Test.class).priority()));

        if (beforeSuit != null){
            beforeSuit.invoke(testInstance);
        }

        for (Method method : methodsList){
            method.invoke(testInstance);
        }

        if (afterSuit != null){
            afterSuit.invoke(testInstance);
        }
    }
}
