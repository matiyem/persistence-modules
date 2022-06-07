package com.example.tableExists;

import java.sql.*;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 1:53 PM
**/
public class TableChecker {
    public static void printAllTables(Connection connection,String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, new String[] {"TABLE"});

        while(resultSet.next()){
            String name = resultSet.getString("TABLE_NAME");
            String schema = resultSet.getString("TABLE_SCHEM");
            System.out.println(name + " on schema " + schema);
        }

    }
    public static boolean tableExists(Connection connection,String tableName) throws SQLException {
        DatabaseMetaData meta= connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});

        return resultSet.next();
    }
    public static boolean tableExistsSQL(Connection connection,String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) " +
                "FROM information_schema.tables " +
                "WHERE table_name = ?" +
                "LIMIT 1;");
        preparedStatement.setString(1,tableName);

        ResultSet resultSet= preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) !=0;
    }
}
