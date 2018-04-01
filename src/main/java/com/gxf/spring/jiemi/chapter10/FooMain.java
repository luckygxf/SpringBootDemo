package com.gxf.spring.jiemi.chapter10;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 58 on 2018/4/1.
 */
public class FooMain {

    public static void main(String[] args) {
        test2();
    }

    private static void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = ctx.getBean("target");
        ((Foo) proxy).method1();
        ((Foo)proxy).method2();
    }

    private static void test1(){
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }
}
