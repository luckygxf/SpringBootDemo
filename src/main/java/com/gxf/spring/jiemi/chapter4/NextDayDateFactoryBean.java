package com.gxf.spring.jiemi.chapter4;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by 58 on 2018/3/27.
 */
public class NextDayDateFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return "guanxianseng";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
