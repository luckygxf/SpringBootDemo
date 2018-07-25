package com.gxf.factorybean_demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public  void testInit(){
        System.out.println("Person222 : " + JSON.toJSONString(this));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person111 : " + JSON.toJSONString(this));
    }
}
