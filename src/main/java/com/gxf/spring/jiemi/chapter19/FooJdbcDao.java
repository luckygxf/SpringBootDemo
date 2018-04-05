package com.gxf.spring.jiemi.chapter19;

import java.sql.Connection;

/**
 * Created by 58 on 2018/4/5.
 */
public class FooJdbcDao implements IDao {
    @Override
    public void doDataAccess() {
        Connection connection = (Connection) TransactionResourceManager.getResource();
        //....
    }
}
