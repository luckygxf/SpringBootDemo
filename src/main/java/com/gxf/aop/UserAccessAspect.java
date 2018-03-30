package com.gxf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 58 on 2018/3/30.
 */
@Aspect
@Configuration
public class UserAccessAspect {
    private static Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);

    @Before("execution(* com.gxf.aop.*.*(..)))")
    public void before(JoinPoint joinPoint){
        logger.info("check for user access");
        logger.info("allowed execution for {}", joinPoint);
    }
}
