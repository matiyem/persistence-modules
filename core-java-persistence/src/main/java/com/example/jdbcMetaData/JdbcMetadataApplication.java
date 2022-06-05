package com.example.jdbcMetaData;

import org.apache.log4j.Logger;

/*
    Create by Atiye Mousavi 
    Date: 5/30/2022
    Time: 2:14 PM
**/
public class JdbcMetadataApplication {
    private static final Logger LOG = Logger.getLogger(JdbcMetadataApplication.class);

    public static void main(String[] args) {
        DatabaseConfig databaseConfig=new DatabaseConfig();
        databaseConfig.init();


    }

}
