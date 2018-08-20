package com.gxf.configuration;

import com.gxf.listeners.ApplicationStartListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/8/16 上午10:18
 * @Modified by:
 **/
@Configuration
public class ListenConfig {

    @Bean
    public ApplicationStartListener applicationStartListener(){
        return new ApplicationStartListener();
    }
}
