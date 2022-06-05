package com.example.statmentVsPreparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 5/31/2022
    Time: 1:17 PM
**/
public class DatasourceFactory {

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:db_basic", "SA", "");
        connection.setAutoCommit(false);
        return connection;
    }
    public boolean createTables() throws SQLException {
        String query = "create table if not exists PERSONS (ID INT, NAME VARCHAR(45))";
        return connection.createStatement().executeUpdate(query) == 0;
    }
}
