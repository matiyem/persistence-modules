package com.example.connectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 5/30/2022
    Time: 1:35 PM
**/
public class C3p0DataSource {
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("org.h2.Driver");
            cpds.setJdbcUrl("jdbc:h2:mem:test");
            cpds.setUser("user");
            cpds.setPassword("password");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
    private C3p0DataSource(){}
}
