package com.gxf.spring.jiemi.chapter9;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created by 58 on 2018/3/31.
 */
public class ProxyFactoryTest {
    public static void main(String[] args) {
        ProxyFactory weaver = new ProxyFactory(new Executable());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        Executable proxyObject = (Executable) weaver.getProxy();
        proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }
}
