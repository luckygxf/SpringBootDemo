package com.gxf.spring.jiemi.chapter9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by 58 on 2018/3/31.
 */
public class PerformanceMethodInterceptor implements MethodInterceptor {
    private static Logger logger = LoggerFactory.getLogger(PerformanceMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try{
            watch.start();
            return invocation.proceed();
        }finally {
            watch.stop();
            if(logger.isInfoEnabled()){
                logger.info(watch.toString());
            }
        }
    }
}
