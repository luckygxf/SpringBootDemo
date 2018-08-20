package com.gxf.other;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/8/16 下午2:12
 * @Modified by:
 **/
public class JSONDemo {

    @Test
    public void testParse(){
        String s = "{'intentType': 'query', 'slot': '{\"restrictAtt\": {\"driverId\": \"22\", \"dt\": \"\"}, \"searchAtt\": [\"onlineTime\"]}', 'sessionId': '123', 'intentCode': '0205'}";
        Map<String, String> map = JSONObject.parseObject(s, Map.class);
        System.out.println(map.get("slot"));
        String slotMap = map.get("slot");
        Map<String, JSONObject> map2 = JSONObject.parseObject(slotMap, Map.class);
        Map<String, String> map3 = JSONObject.parseObject(map2.get("restrictAtt").toJSONString(), Map.class);
        System.out.println("map3: " + map3);


    }
}
