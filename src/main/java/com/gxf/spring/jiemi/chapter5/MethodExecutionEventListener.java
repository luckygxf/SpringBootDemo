package com.gxf.spring.jiemi.chapter5;

import java.util.EventListener;

/**
 * Created by 58 on 2018/3/28.
 */
public interface MethodExecutionEventListener extends EventListener {

    /**
     *
     * */
    public void onMethodBegin(MethodExecutionEvent evt);

    public void onMethodEnd(MethodExecutionEvent evt);
}
