package com.example.resultSetRowCount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 1:46 PM
**/
public class ScrollableRowCounter {

    Connection conn;

    public ScrollableRowCounter(Connection conn) {
        this.conn = conn;
    }

    public int getQueryRowCount(String query) throws SQLException {
        try (Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet scrollableRS = statement.executeQuery(query)) {
            scrollableRS.last();
            return scrollableRS.getRow();
        }

    }
}
