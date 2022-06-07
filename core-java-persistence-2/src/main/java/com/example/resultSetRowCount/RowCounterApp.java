package com.example.resultSetRowCount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 1:20 PM
**/
public class RowCounterApp {
    public static void main(String[] args) throws SQLException {
        Connection conn = createDummyDB();

        String selectQuery = "SELECT * FROM STORAGE";

        StandardRowCounter standardCounter = new StandardRowCounter(conn);
        assert standardCounter.getQueryRowCount(selectQuery) == 3;

        ScrollableRowCounter scrollableCounter = new ScrollableRowCounter(conn);
        assert scrollableCounter.getQueryRowCount(selectQuery) == 3;
    }

   public static Connection createDummyDB() throws SQLException {
        String dbUrl = "jdbc:h2:mem:storagedb";
        Connection conn = DriverManager.getConnection(dbUrl);
        try (Statement statement = conn.createStatement()) {
            String sql = "CREATE TABLE STORAGE (id INTEGER not null, val VARCHAR(50), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
            statement.executeUpdate(sql);
            sql = "INSERT INTO STORAGE VALUES (1, 'Entry A')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO STORAGE VALUES (2, 'Entry A')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO STORAGE VALUES (3, 'Entry A')";
            statement.executeUpdate(sql);
        }
        return conn;

    }
}
