package com.gxf.controller;

/**
 * Created by 58 on 2018/3/6.
 */
public class StackTraceTest {
    public static void main(String[] args) {
//        Person.test();
        springMethod();
    }

    public static void test(){
        StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();
        for(StackTraceElement stackTraceElement : stackTraceElements){
            stackTraceElement.getMethodName();
        }
    }

    public static Class<?> springMethod(){
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        }
        catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        return null;
    }
}
