package com.example.tableExists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 1:51 PM
**/
public class DatabaseConfig {
    public static Connection connect() throws SQLException, ClassNotFoundException {

        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:mem:testdb";
        return DriverManager.getConnection(url, "user", "password");
    }
   public  static void createTables(Connection connection) throws SQLException {
        connection.createStatement().executeUpdate("create table EMPLOYEE (id int primary key auto_increment, name VARCHAR(255))");
    }

    public static void dropTables(Connection connection) throws SQLException {
        connection.createStatement().executeUpdate("drop table EMPLOYEE");
    }

}
