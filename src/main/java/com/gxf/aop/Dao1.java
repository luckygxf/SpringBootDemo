package com.gxf.aop;

import org.springframework.stereotype.Repository;

/**
 * Created by 58 on 2018/3/30.
 */
@Repository
public class Dao1 {
    public String retrieveSomething(){
        return "Dao1";
    }
}
