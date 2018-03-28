package com.gxf.spring.jiemi.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 58 on 2018/3/28.
 */
public class MethodExecutionEventPublisher {
    private List<MethodExecutionEventListener> listeners = new ArrayList<>();

    public static void main(String[] args) {
        MethodExecutionEventPublisher eventPublisher = new MethodExecutionEventPublisher();
        eventPublisher.addListener(new SimpleMethodExecutionEventListener());
        eventPublisher.method2Monitor();
    }

    public void method2Monitor(){
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this, "method2Monitor");
        publishEvent(MethodExecutionStats.BEGIN, event2Publish);
        publishEvent(MethodExecutionStats.END, event2Publish);
    }

    protected void publishEvent(MethodExecutionStats stats, MethodExecutionEvent methodExecutionEvent){
        List<MethodExecutionEventListener> copyListeners = new ArrayList<>(listeners);
        for(MethodExecutionEventListener listener : copyListeners){
            if(MethodExecutionStats.BEGIN.getStatus().equals(stats.getStatus())){
                listener.onMethodBegin(methodExecutionEvent);
            }else{
                listener.onMethodEnd(methodExecutionEvent);
            }
        }
    }

    public void addListener(MethodExecutionEventListener listener){
        listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener){
        if (listeners.contains(listener)){
            listeners.remove(listener);
        }
    }
}
