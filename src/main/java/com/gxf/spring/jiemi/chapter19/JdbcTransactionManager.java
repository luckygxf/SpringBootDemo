package com.gxf.spring.jiemi.chapter19;

import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 58 on 2018/4/5.
 */
public class JdbcTransactionManager implements PlatformTransactionManager {
    private DataSource dataSource;

    public JdbcTransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            TransactionResourceManager.bindResource(connection);
            return new DefaultTransactionStatus(connection, true, true, false, true, null);
        } catch (SQLException e) {
            throw new CannotCreateTransactionException("cannot get connection for tx", e);
        }

    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unBindResource();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TransactionSystemException("commit failed", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unBindResource();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnexpectedRollbackException("rollback fail with sqlexcetption", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
