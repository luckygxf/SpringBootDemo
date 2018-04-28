package com.gxf.other;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 58 on 2018/3/31.
 */
public class Child {

    @Test
    public void test(){
        long chatId = 10000L;
        Map<String, Object> map = new HashMap<>();
        map.put("chat_history_id", chatId);
        String s =  JSON.toJSONString(map);
        System.out.println(s);
    }
}
