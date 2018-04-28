package com.gxf.circule_beans;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 58 on 2018/3/19.
 */
@Component
public class CirclairtyC {
    private String s;
    @Autowired
    private CirclairtyA circlairtyA;

    public void c(){
        circlairtyA.a();
    }

    public CirclairtyC() {
        s = "CirclairtyC";
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

    public CirclairtyA getCirclairtyA() {
        return circlairtyA;
    }

    public void setCirclairtyA(CirclairtyA circlairtyA) {
        this.circlairtyA = circlairtyA;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
