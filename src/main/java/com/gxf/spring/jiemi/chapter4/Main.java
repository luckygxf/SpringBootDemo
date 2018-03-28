package com.gxf.spring.jiemi.chapter4;

import com.gxf.circule_beans.CirclairtyA;
import com.gxf.circule_beans.CirclairtyB;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Created by 58 on 2018/3/26.
 */
public class Main {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        //bind by xml file
        BeanFactory container = bindViaXmlFile(beanRegistry);

        testDate(container);
    }

    /**
     * 测试date
     * */
    public static void testDate(BeanFactory beanFactory){
        DateFoo dateFoo = (DateFoo) beanFactory.getBean("dateFoo");
        System.out.println(dateFoo);
    }

    /**
     * 测试FactoryBean
     * */
    public static void testFactoryBean(BeanFactory beanFactory){
        NextDayDateDisplayer nextDayDateDisplayer = (NextDayDateDisplayer) beanFactory.getBean("nextDayPlayer");
        System.out.println(nextDayDateDisplayer.getDateOfNextDay());
    }

    /***
     * 测试从beanfacotry中拿数据
     * */
    public static void getBeanFromFactory(BeanFactory beanFactory){
        MockBuinessObject mockBO = (MockBuinessObject) beanFactory.getBean("mockBO");
        System.out.println(mockBO);
    }


    /**
     * xml定义beans
     * */
    public static BeanFactory bindViaXmlFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:beans.xml");
        return (BeanFactory) registry;
    }
}
