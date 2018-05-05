package com.gxf.distri_lock.version_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MysqlPrimaryLock {

    private static Connection connection;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/distri_lock";
        try{
            connection = DriverManager.getConnection(url);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 加锁
     * */
    public void lock(String lockId){
        acquire(lockId);
    }


    /**
     * 获取锁
     * */
    public boolean acquire(String lockId){
        String sql = "insert into lock_test(id, count, th_name, addtime) values(1, 1, 'guanxiangfei', '2018-5-5')";
        while(true){
            try{
                PreparedStatement statement = connection.prepareStatement(sql);
                boolean isSuccess = statement.execute(sql);
                if(isSuccess){
                    return true;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            continue;
        } //while
    }

    /**
     * 超时获取锁
     * */
    public boolean acquire(String lockId, long timeOut) throws InterruptedException {
        String sql = "insert into lock_test(id, count, th_name, addtime) values(1, 1, 'guanxiangfei', '2018-5-5')";
        long futureTime = System.currentTimeMillis() + timeOut;
        long ranmain = timeOut;
        long timeRange = 500;
        while(true){
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try{
                PreparedStatement statement = connection.prepareStatement(sql);
                boolean isSuccess = statement.execute();
                if(isSuccess){
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            countDownLatch.await(timeRange, TimeUnit.MILLISECONDS);
            ranmain = futureTime - System.currentTimeMillis();
            if(ranmain <= 0)
                break;
            if(ranmain < timeRange)
                timeRange = ranmain;
            continue;
        }
        return false;
    }
}
