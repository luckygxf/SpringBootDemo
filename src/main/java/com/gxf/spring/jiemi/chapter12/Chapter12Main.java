package com.gxf.spring.jiemi.chapter12;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Created by 58 on 2018/4/2.
 */
public class Chapter12Main {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory(new NestableInvocationBO());
        weaver.setProxyTargetClass(true);
        weaver.setExposeProxy(true);
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        ((NestableInvocationBO)proxy).method2();
        ((NestableInvocationBO)proxy).method1();
    }
}
