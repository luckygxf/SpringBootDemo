package com.gxf.distri_lock;

import redis.clients.jedis.Jedis;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisLockTest {
    String host = "localhost";
    int port = 6379;
    private Jedis jedisCli = new Jedis(host, port);
    private int expireTime = 1;


    /**
     * 获取锁
     * */
    public boolean lock(String lockId){
        while(true){
            long returnFlag = jedisCli.setnx(lockId, "1");
            if(returnFlag == 1){
                System.out.println(Thread.currentThread().getName() + " get lock...");
                return true;
            } //if
            System.out.println(Thread.currentThread().getName() + " is trying lock...");
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    } //lock


    /**
     * 超时获取锁
     * */
    public boolean lock(String lockId, long timeOuts){
        long current = System.currentTimeMillis() + timeOuts;
        long future = current + timeOuts;
        long timeStep = 500;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        while(future > current){
            long returnFlag = jedisCli.setnx(lockId, "1");
            if(returnFlag == 1){
                System.out.println(Thread.currentThread().getName() + " get lock...");
                jedisCli.expire(lockId, expireTime);
                return true;
            } //if
            System.out.println(Thread.currentThread().getName() + " trying get lock...");
            try{
                countDownLatch.await(timeOuts, TimeUnit.MILLISECONDS);
            }catch (Exception e){
                e.printStackTrace();
            }
            current = current + timeStep;
        } //while
        return false;
    }

    /**
     * 释放锁
     * */
    public void unlock(String lockId){
        long flag = jedisCli.del(lockId);
        if(flag > 0){
            System.out.println(Thread.currentThread().getName() + " unlock ...");
        }else{
            System.out.println(Thread.currentThread().getName() + " unlock failed...");
        }
    }

    /**
     * 命名线程工厂
     * */
    public static class MyThreadFactory implements ThreadFactory{
        private static AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            count.getAndIncrement();
            Thread thread = new Thread(r);
            thread.setName("Thread-lock-test " + count);
            return thread;
        }
    }

    public static void main(String[] args) {
        final String lockId = "test1";
        Runnable task = () ->{
            System.out.println("start task...");
            RedisLockTest testCli = new RedisLockTest();
            //申请锁
            testCli.lock(lockId);
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
            //释放锁
            testCli.unlock(lockId);
        };

        MyThreadFactory factory = new MyThreadFactory();
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new MyThreadFactory());
        for(int i = 0; i < 3; i ++){
            threadPoolExecutor.execute(task);
        }

        try{
           Thread.sleep(1000000000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
