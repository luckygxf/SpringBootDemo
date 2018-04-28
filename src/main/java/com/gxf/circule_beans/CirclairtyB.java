package com.gxf.circule_beans;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 58 on 2018/3/19.
 */
@Component
public class CirclairtyB {
    private String s;
    @Autowired
    private CirclairtyC circlairtyC;

    public void b(){
        circlairtyC.c();
    }

    public CirclairtyB() {
        s = "CirclairtyB";
    }

    public void print(){
        System.out.println(s);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public CirclairtyC getCirclairtyC() {
        return circlairtyC;
    }

    public void setCirclairtyC(CirclairtyC circlairtyC) {
        this.circlairtyC = circlairtyC;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
