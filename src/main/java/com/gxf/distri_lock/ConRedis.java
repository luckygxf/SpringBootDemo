package com.gxf.distri_lock;

import redis.clients.jedis.Jedis;

/**
 * 连接redis
 * */
public class ConRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        String key = "name";
        String value = jedis.get(key);
        System.out.println("value: " + value);
    }
}
