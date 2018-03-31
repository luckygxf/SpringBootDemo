package com.gxf.spring.jiemi.chapter9;

/**
 * Created by 58 on 2018/3/31.
 */
public class CounterImpl implements ICounter {
    private int counter;

    @Override
    public void resetCounter() {
        counter = 0;
    }

    @Override
    public int getcounter() {
        counter ++;
        return counter;
    }
}
