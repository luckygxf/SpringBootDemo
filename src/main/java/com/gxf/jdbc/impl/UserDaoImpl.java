package com.gxf.jdbc.impl;

import com.gxf.jdbc.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by 58 on 2018/4/2.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(String userName, int userAge, String userAddress) {
        jdbcTemplate.update("INSERT  INTO user(userName, userAge, userAddress) VALUES (?, ?, ?)", userName, userAge, userAddress);
    }
}
