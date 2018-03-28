package com.gxf.spring.jiemi.chapter4;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Created by 58 on 2018/3/27.
 */
public class DateFoo {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
