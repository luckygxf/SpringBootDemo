package com.gxf.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 58 on 2018/3/30.
 */
@Service
public class Business1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Dao1 dao1;

    public String caculateSomething(){
        String value = dao1.retrieveSomething();
        logger.info("In BUSINES -{}", value);
        return value;
    }

}
