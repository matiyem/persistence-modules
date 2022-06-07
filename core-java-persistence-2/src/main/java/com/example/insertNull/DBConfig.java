package com.example.insertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 11:13 AM
**/
public class DBConfig {
    private static Connection INSTANCE;

    public static Connection getConnection() throws SQLException {
        if (INSTANCE==null){
            INSTANCE= DriverManager.getConnection("jdbc:h2:mem:insertnull","user","password");
            createPersonTable();
        }
        return INSTANCE;
    }
    private static void createPersonTable() throws SQLException {
        try(Statement statement=INSTANCE.createStatement()){
            String sql = "CREATE TABLE Person (id INTEGER not null, name VARCHAR(50), lastName VARCHAR(50), age INTEGER, PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }
    }
}
