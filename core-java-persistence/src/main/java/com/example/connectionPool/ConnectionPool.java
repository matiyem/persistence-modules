package com.example.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/30/2022
    Time: 12:49 PM
**/
public interface ConnectionPool {

    Connection getConnection() throws SQLException;

    boolean releaseConnection(Connection connection);

    List<Connection> getConnectionPool();

    int getSize();

    String getUrl();

    String getUser();

    String getPassword();

    void shutdown() throws SQLException;
}
