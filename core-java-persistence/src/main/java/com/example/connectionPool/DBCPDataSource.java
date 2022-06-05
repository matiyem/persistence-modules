package com.example.connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 5/30/2022
    Time: 2:00 PM
**/
public class DBCPDataSource {
    private static final BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:h2:mem:test");
        ds.setUsername("user");
        ds.setPassword("password");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    private DBCPDataSource(){}
}
