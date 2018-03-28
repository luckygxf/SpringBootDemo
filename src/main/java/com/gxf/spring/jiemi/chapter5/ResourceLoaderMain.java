package com.gxf.spring.jiemi.chapter5;

import org.springframework.core.io.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by GuanXF on 2018/3/28.
 */
public class ResourceLoaderMain {
    public static void main(String[] args) {
        testFileResource();
    }

    public static void testResourceLoader(){
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fileResource = resourceLoader.getResource("D:/BugReport.txt");
        if(fileResource instanceof ClassPathResource){
            System.out.println("classpathresource");
        }
        if(fileResource instanceof FileSystemResource){
            System.out.println("file resource");
        }
        try {
            File file = fileResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFileResource(){
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("D:/BugReport.txt");
        if(fileResource instanceof ClassPathResource){
            System.out.println("classpathresource");
        }
        if(fileResource instanceof FileSystemResource){
            System.out.println("file resource");
        }
        System.out.println(fileResource.exists());
        if(fileResource instanceof UrlResource){
            System.out.println("url resource");
        }
    }
}
