package com.gxf.spring.jiemi;

import com.gxf.circule_beans.CirclairtyA;
import com.gxf.circule_beans.CirclairtyB;
import com.gxf.circule_beans.CirclairtyC;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Created by 58 on 2018/3/26.
 */
public class BeanFactoryImpl {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        CirclairtyA circlairtyA = (CirclairtyA) container.getBean("circlairtyA");
        circlairtyA.print();
        System.out.println(circlairtyA);
    }


    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition circlairtyA = new RootBeanDefinition(CirclairtyA.class);
        AbstractBeanDefinition circlairtyB = new RootBeanDefinition(CirclairtyB.class);
        AbstractBeanDefinition circlairtyC = new RootBeanDefinition(CirclairtyC.class);

        //regist bean to ioc container
        registry.registerBeanDefinition("circlairtyA", circlairtyA);
        registry.registerBeanDefinition("circlairtyB", circlairtyB);
        registry.registerBeanDefinition("circlairtyC", circlairtyC);
        //regist by setter
        MutablePropertyValues aPropertyValues = new MutablePropertyValues();
        aPropertyValues.addPropertyValue(new PropertyValue("circlairtyB", circlairtyB));

        //regist b to a
        circlairtyA.setPropertyValues(aPropertyValues);

        //regist c to b
        MutablePropertyValues bPropertyValues = new MutablePropertyValues();
        bPropertyValues.addPropertyValue(new PropertyValue("circlairtyC", circlairtyC));

        return (BeanFactory) registry;
    }
}
