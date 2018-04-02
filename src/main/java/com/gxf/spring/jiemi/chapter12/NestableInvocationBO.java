package com.gxf.spring.jiemi.chapter12;

import org.springframework.aop.framework.AopContext;

/**
 * Created by 58 on 2018/4/2.
 */
public class NestableInvocationBO {

    public void method1(){
//        method2();
        ((NestableInvocationBO)AopContext.currentProxy()).method2();
        System.out.println("method1 executed.");
    }

    public void method2(){
        System.out.println("method2 executed.");
    }
}
