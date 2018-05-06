package com.gxf.lock_jdk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new Increament());
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //for
        System.out.println("count: " + count);
    }


    //use jdk lock
    static class IncrementLock implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10000; i ++){
                lock.lock();
                count ++;
                lock.unlock();
            } //for
        }
    }

    //use synchronized
    static class Increament implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10000; i ++){
                synchronized (LockDemo.class){
                    count ++;
                } //syn
            } //for
        } //run
    }


}
