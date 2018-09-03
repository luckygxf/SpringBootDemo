package com.gxf.beans;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/8/21 上午9:52
 **/
public class Dog implements FactoryBean<Cat> {
    private String name;
    private Class friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getFriend() {
        return friend;
    }

    public void setFriend(Class friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public Cat getObject() throws Exception {
        return new Cat("Black cat");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
