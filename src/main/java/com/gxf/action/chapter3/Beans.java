package com.gxf.action.chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 58 on 2018/4/28.
 */
@Configuration
public class Beans {

    @Bean(name = "juggler")
    public Performer juggler(){
        return new Juggler();
    }
}
