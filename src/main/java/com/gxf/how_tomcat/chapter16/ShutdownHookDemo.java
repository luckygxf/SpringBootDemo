package com.gxf.how_tomcat.chapter16;

import java.io.IOException;

/**
 * Created by 58 on 2018/4/12.
 */
public class ShutdownHookDemo {
    public void start(){
        System.out.println("Demo");
        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public static void main(String[] args) {
        ShutdownHookDemo shutdownHookDemo = new ShutdownHookDemo();
        shutdownHookDemo.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    class ShutdownHook extends  Thread{
        @Override
        public void run(){
            System.out.println("shutdown hook");
        }
    }
}
