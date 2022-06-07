package com.example.connectionStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 10:43 AM
**/
public class ConnectionValidation {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        String url="jdbc:h2:mem:testdb";
        return DriverManager.getConnection(url,"user","password");
    }

    public static void runIfOpened(Connection connection) throws SQLException {
        if (connection !=null && !connection.isClosed()){
            // run sql statements

        }else {
            // handle closed connection

        }
    }
    public static void runIfConnectionValid(Connection connection) throws SQLException {
        if (isConnectionValid(connection)){
            // run sql statements

        }else {
            // handle invalid connection

        }
    }

    public static boolean isConnectionValid(Connection connection) throws SQLException {

        try {
            if (connection !=null && !connection.isClosed()){
                connection.prepareStatement("SELECT  1");
                return true;
            }
        } catch (SQLException e) {
            // log some useful data here
        }
        return false;
    }
}
