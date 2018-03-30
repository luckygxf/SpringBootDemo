package com.gxf.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 58 on 2018/3/30.
 */
@Service
public class Business2 {
    @Autowired
    private Dao2 dao2;

    public String calculateSomething(){
        return dao2.retriveSomething();
    }
}
