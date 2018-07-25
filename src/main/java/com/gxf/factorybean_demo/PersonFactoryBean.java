package com.gxf.factorybean_demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PersonFactoryBean implements FactoryBean<Person>, ApplicationContextAware , InitializingBean {
    private String personInfo;
    private ApplicationContext applicationContext;

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


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println(applicationContext);
        Object object = applicationContext.getBean("person");
        System.out.println("object: " + object);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet : " + personInfo);
    }
}
