package com.gxf.distri_lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    static class DefualtThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Execute task...");
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new DefualtThreadFactory());
        Task task = new Task();
        threadPoolExecutor.execute(task);
    }
}
