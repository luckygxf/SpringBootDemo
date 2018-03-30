package com.gxf.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 58 on 2018/3/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {
    private Logger logger = LoggerFactory.getLogger(BusinessAopSpringBootTest.class);
    @Autowired
    private Business1 business1;
    @Autowired
    private Business2 business2;

    @Test
    public void invokeAOPStuff(){
        logger.info(business1.caculateSomething());
        logger.info(business2.calculateSomething());
    }

}
