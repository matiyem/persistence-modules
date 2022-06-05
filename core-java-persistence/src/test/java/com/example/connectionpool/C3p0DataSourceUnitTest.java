package com.example.connectionpool;

import com.example.connectionPool.C3p0DataSource;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class C3p0DataSourceUnitTest {
    
    @Test
    public void givenC3p0DataSourceClass_whenCallGetConnection_thenCorrect() throws SQLException {
        assertTrue(C3p0DataSource.getConnection().isValid(1));
    }   
}