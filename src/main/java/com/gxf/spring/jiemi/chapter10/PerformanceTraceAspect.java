package com.gxf.spring.jiemi.chapter10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by 58 on 2018/4/1.
 */
@Aspect
public class PerformanceTraceAspect {
    private final Logger logger = LoggerFactory.getLogger(PerformanceTraceAspect.class);

    @Pointcut("execution(public void *.method1()) || execution(public void *.method2())")
    public void pointcutName(){

    }

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            watch.stop();
            if(logger.isInfoEnabled()){
                logger.info("pt in method[ " + joinPoint.getSignature().getName() +
                " ] >>>> " + watch.toString());
            }
        }
        return null;
    }
}
