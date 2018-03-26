package com.gxf.circule_beans;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 58 on 2018/3/19.
 */
@Component
public class CirclairtyA {
    private String s;
    @Autowired
    private CirclairtyB circlairtyB;

    public CirclairtyA() {
        s = "CirclairtyA";
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

    public CirclairtyB getCirclairtyB() {
        return circlairtyB;
    }

    public void setCirclairtyB(CirclairtyB circlairtyB) {
        this.circlairtyB = circlairtyB;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
