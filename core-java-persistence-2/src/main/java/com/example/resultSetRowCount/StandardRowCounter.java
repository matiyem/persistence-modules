package com.example.resultSetRowCount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 1:42 PM
**/
public class StandardRowCounter {
    Connection conn;

    public StandardRowCounter(Connection conn) {
        this.conn = conn;
    }

  public   int getQueryRowCount(String query) throws SQLException {
        try (Statement statement = conn.createStatement(); ResultSet standardRS = statement.executeQuery(query)) {
            int size = 0;
            while (standardRS.next()) {
                size++;
            }
            return size;
        }

    }
}
