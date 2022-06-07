package com.example.getDbUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 11:06 AM
**/
public class DBConfiguration {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:mem:testdb";
        return DriverManager.getConnection(url,"user","password");

    }
}
