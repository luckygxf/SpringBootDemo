package com.gxf.proxy_demo;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class ProxyService {

    public static void main(String[] args) {
        MyService myService = new MyService();
        ProxyFactory proxyFactory = new ProxyFactory(myService);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("before method");
            }
        });


        MyService mysServiceProxy = (MyService) proxyFactory.getProxy();
        mysServiceProxy.service();
    }
}
