package com.gxf.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 58 on 2018/3/6.
 */
public class StackTraceTest {
    public static void main(String[] args) {
//        Person.test();
        springMethod();
    }

    public void travelList(){
        List<String> list = null;
        Map<String, Object>  map = null;
        //遍历1
        for(String s : list){
            System.out.println(s);
        }
        //遍历2
        for(int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        //遍历3
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历map1
        for(String s : map.keySet()){
            System.out.println(s + ", " + map.get(s));
        }
        //遍历map2
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    public static void test(){
        StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();
        for(StackTraceElement stackTraceElement : stackTraceElements){
            stackTraceElement.getMethodName();
        }
    }

    public static Class<?> springMethod(){
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        }
        catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        return null;
    }
}
