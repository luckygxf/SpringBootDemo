package com.gxf.utils;

import com.gxf.configuration.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by 58 on 2018/3/6.
 */
@Component
public class ConfigurationUtil {
    @Autowired
    private Configurations configurations;

    public void getApplicationConfiguration(){
        System.out.println("getApplicationConfiguration userName: " + configurations.getUserName());
        System.out.println("getApplicationConfiguration userAge: " + configurations.getAge());

    }
}
