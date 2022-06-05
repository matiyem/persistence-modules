package com.example.connectionpool;

import com.example.connectionPool.HikariCPDataSource;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class HikariCPDataSourceUnitTest {
    
    @Test
    public void givenHikariDataSourceClass_whenCalledgetConnection_thenCorrect() throws SQLException {
        assertTrue(HikariCPDataSource.getConnection().isValid(1));
    }   
}