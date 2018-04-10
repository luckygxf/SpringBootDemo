package com.gxf.how_tomcat.chapter7;

/**
 * Created by 58 on 2018/4/10.
 */
public class TestException {
    public static void main(String[] args) {
        try{
            test();
        }catch (Exception e){
            System.out.println(e.getMessage());
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for(StackTraceElement stackTraceElement : stackTraceElements){
                System.out.println(stackTraceElement.getClassName() + ", " + stackTraceElement.getMethodName() + ", " + stackTraceElement.getFileName()
                                + ", " + stackTraceElement.getLineNumber());
            }
            e.printStackTrace();
        }
    }

    private static void test(){
        int a = 1 / 0;
    }
}
