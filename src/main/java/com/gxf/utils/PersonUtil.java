package com.gxf.utils;

import com.gxf.entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 58 on 2018/3/6.
 */
@Component
public class PersonUtil {

    @Bean(name = "person")
    public Person getPerson(){
        Person gxf = new Person();
        gxf.setName("guanxiangfei");
        return gxf;
    }
}
