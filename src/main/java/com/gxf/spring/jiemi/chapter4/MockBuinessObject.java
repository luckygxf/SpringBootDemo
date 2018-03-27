package com.gxf.spring.jiemi.chapter4;

import com.alibaba.fastjson.JSON;

/**
 * Created by 58 on 2018/3/26.
 */
public class MockBuinessObject {
    private String d1;
    private String d3;
    private int d2;

    public MockBuinessObject(String d1, String d3) {
        this.d1 = d1;
        this.d3 = d3;
    }

    public MockBuinessObject(String d1) {
        this.d1 = d1;
    }

    public MockBuinessObject(int d2) {
        this.d2 = d2;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
