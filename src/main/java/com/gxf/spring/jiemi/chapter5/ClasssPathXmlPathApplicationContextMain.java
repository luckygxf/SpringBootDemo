package com.gxf.spring.jiemi.chapter5;

import com.gxf.utils.FileUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;

/**
 * Created by 58 on 2018/3/28.
 */
public class ClasssPathXmlPathApplicationContextMain {
    public static void main(String[] args) {
        loadFile();
    }

    public static void loadFile(){
        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("beans.xml");
        Resource fileResource = resourceLoader.getResource("test.txt");
        if(fileResource instanceof ClassPathResource){
            System.out.println("classpath resource");
        }
        try {
            File file = fileResource.getFile();
            FileUtil.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileResource.exists());
        Resource urlResource = resourceLoader.getResource("https://www.baidu.com");
        if(urlResource instanceof UrlResource){
            System.out.println("url resource");
        }
    }
}
