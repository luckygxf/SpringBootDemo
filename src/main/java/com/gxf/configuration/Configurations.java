package com.gxf.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 58 on 2018/3/6.
 */
@Configuration
public class Configurations {

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
