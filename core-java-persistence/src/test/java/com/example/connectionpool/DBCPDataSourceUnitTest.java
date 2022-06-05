package com.example.connectionpool;

import com.example.connectionPool.DBCPDataSource;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class DBCPDataSourceUnitTest {
    
    @Test
    public void givenDBCPDataSourceClass_whenCalledgetConnection_thenCorrect() throws SQLException {
        assertTrue(DBCPDataSource.getConnection().isValid(1));
    }   
}