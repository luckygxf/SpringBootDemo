package com.gxf.spring.jiemi.chapter5;

/**
 * Created by 58 on 2018/3/28.
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
    @Override
    public void onMethodBegin(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("start to exe method : [ " + methodName + " ]");
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("finish to exe method : [ " + methodName + " ]");
    }
}
