package com.gxf.spring.jiemi.chapter12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by 58 on 2018/4/2.
 */
@Aspect
public class PerformanceTraceAspect {
    private final Logger logger = LoggerFactory.getLogger(PerformanceTraceAspect.class);

    @Pointcut("execution(public void *.method1())")
    public void method1(){

    }

    @Pointcut("execution(public void *.method2())")
    public void method2(){

    }

    @Pointcut("method1() || method2()")
    public void compositePointcut(){

    }

    @Around("compositePointcut()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed();
        } finally {
            watch.stop();
            logger.info("pt in method[ " + joinPoint.getSignature().getName() + " ]>>>" + watch.toString());
        }

    }
}
