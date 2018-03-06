package com.gxf.entities;

/**
 * Created by 58 on 2018/3/6.
 */
public class Person {
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void test(){
        StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();
        for(StackTraceElement stackTraceElement : stackTraceElements){
            stackTraceElement.getMethodName();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
