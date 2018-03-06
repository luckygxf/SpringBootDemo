package com.gxf.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by 58 on 2018/3/6.
 */
@Component
public class DIEnvironment {
    @Autowired
    private Environment environment;

    public String getProValueFromEnviroment(String key){
        return environment.getProperty(key);
    }
}
