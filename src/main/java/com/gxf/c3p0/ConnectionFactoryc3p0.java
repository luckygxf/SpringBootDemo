package com.gxf.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactoryc3p0 {
    public static ComboPooledDataSource comboPooledDataSource = null;
    static {
        // 初始化 c3p0 JDBC数据连接与控制池
        comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource
                .setJdbcUrl("jdbc:mysql://localhost:3306/db_test?useUnicode=true&amp");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("luckygxf");
        comboPooledDataSource.setMinPoolSize(20);
        comboPooledDataSource.setMaxPoolSize(50);
    }

    public static synchronized Connection getC3p0Connection() {
        Connection con=null;
        try {
            con= comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return con;
        }
    }
    public static void main(String[] args) {
        try {
            //通过c3p0进行查询操作
            ResultSet rs = ConnectionFactoryc3p0.getC3p0Connection()
                    .prepareStatement("select * from t_user").executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

    }
}