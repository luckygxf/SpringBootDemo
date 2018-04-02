package com.gxf.dao;

import com.gxf.Application;
import com.gxf.jdbc.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 58 on 2018/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Test
    public void insert(){
        String name = "guanxiangfei";
        int age = 28;
        String address = "Chengdu";
        userDao.insert(name, age, address);
    }
}
