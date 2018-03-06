package com.gxf;

import com.gxf.environment.DIEnvironment;
import com.gxf.utils.ConfigurationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

/**
 * Created by GuanXF on 2018/3/5.
 */
@SpringBootApplication
@PropertySource(value = {"classpath:gxf.properties"})
public class Application {
    @Autowired
    private DIEnvironment diEnvironment;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        testEnvironment(context);
    }


    /**
     * test environment
     * */
    private static void testEnvironment(ApplicationContext context){
        DIEnvironment dIEnvironment = (DIEnvironment) context.getBean("DIEnvironment");
        String name = dIEnvironment.getProValueFromEnviroment("user.name1");
        System.out.println("name: "+ name);
        String age = dIEnvironment.getProValueFromEnviroment("user.age");
        System.out.println("age: " + age);
        String guanName = dIEnvironment.getProValueFromEnviroment("guanxianseng.name");
        System.out.println("guanName: " + guanName);
        String guanAge = dIEnvironment.getProValueFromEnviroment("guanxianseng.age");
        System.out.println("guanAge: " + guanAge);
    }

    private static void testConfig(ApplicationContext context){
        ConfigurationUtil configurationUtil = (ConfigurationUtil) context.getBean("configurationUtil");
        configurationUtil.getApplicationConfiguration();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
