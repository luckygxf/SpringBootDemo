package com.gxf.factorybean_demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class PersonFactoryBean implements FactoryBean<Person> {
    private String personInfo;

    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        String[] infos = personInfo.split(",");
        person.setName(infos[0]);
        person.setAddress(infos[1]);
        person.setAge(Integer.parseInt(infos[2]));

        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }


}
