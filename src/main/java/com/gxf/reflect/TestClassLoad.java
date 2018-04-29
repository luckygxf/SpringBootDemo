package com.gxf.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 58 on 2018/4/28.
 */
public class TestClassLoad {

    public static void main(String[] args) throws Exception {
        doGet();
        doReflectGet();
    }

    public static void doGet() throws Exception {
        long start = System.currentTimeMillis();
        A a = new A();
        for (int i = 0; i < 100000000; i++) {
            a.getI();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void doReflectGet() throws Exception {
        long start = System.currentTimeMillis();
        A a = new A();
        Class<A> cls = A.class;
        Field field = cls.getDeclaredField("I");
        field.setAccessible(true);
        for (int i = 0; i < 100000000; i++) {
            field.get(a);
        }
        System.out.println(System.currentTimeMillis() - start);
    }


    private static void testInstance() throws Exception {
        String classPackage = "com.gxf.reflect.Person";
        Class clazz = Class.forName(classPackage);
        Class[] params = {String.class, Integer.class};
        Object[] values = {"guanxiangfei", 28};
        Constructor constructor = clazz.getConstructor(params);
        Person guanxiangfei = (Person) constructor.newInstance(values);
        System.out.println(guanxiangfei);

    }


    private static void testView(){
        int a = 0;
        Integer b = 0;
        if(b == a){
            System.out.println("a");
        }
        else{
            System.out.println("b");
        }
    }


    private static void testReflect() throws Exception{
        Class a = A.class;
        Constructor constructor = a.getConstructor(a);
        A instance = (A) constructor.newInstance();
        System.out.println(instance);
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
