package com.gxf.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/8/16 上午10:16
 * @Modified by:
 **/
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("我的父容器为： " + contextRefreshedEvent.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了");
    }
}
