package com.example.getdburl;

import com.example.getDbUrl.DBConfiguration;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DBConfigurationUnitTest {

    @Test
    void givenConnectionObject_whenExtractMetaData_thenGetDbURL() throws Exception {
        Connection connection = DBConfiguration.getConnection();
        String dbUrl = connection.getMetaData().getURL();
        assertEquals("jdbc:h2:mem:testdb", dbUrl);
    }

}
