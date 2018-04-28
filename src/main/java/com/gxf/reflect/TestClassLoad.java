package com.gxf.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by 58 on 2018/4/28.
 */
public class TestClassLoad {

    public static void main(String[] args) throws Exception {
        testNewInstance();
    }


    public static void testMethod() throws Exception{
        Class<?> clazz = Class.forName("com.gxf.reflect.A");
        Object object = clazz.newInstance();
        Method method = clazz.getMethod("foo", String.class);
        for(int i = 0; i < 16; i++){
            method.invoke(object, Integer.toString(i));
        }
    }

    public static void testNewInstance() throws Exception {
        Class<?> c = String.class;
        Constructor constructor = c.getConstructor(String.class);
        Object obj = constructor.newInstance("hehe");
        System.out.println(obj);
    }
}
