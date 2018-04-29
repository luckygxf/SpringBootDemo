package com.gxf.reflect;

/**
 * Created by 58 on 2018/4/28.
 */
public class A {
    private String I;
    private String name;

    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void foo(String name){
        System.out.println("hello , " + name);
    }
}
