package com.example.resultSet2Json;

import com.mysql.cj.xdevapi.JsonArray;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.impl.DSL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    Create by Atiye Mousavi 
    Date: 6/6/2022
    Time: 12:29 PM
**/
public class ResultSet2JSON {

    public static void main(String ...args) throws ClassNotFoundException, SQLException {

        ResultSet2JSON testClass=new ResultSet2JSON();
        testClass.convertWithoutJOOQ();
    }
    public void convertWithoutJOOQ() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:mem:rs2jdbc", "user", "password");

        Statement stmt=dbConnection.createStatement();
        stmt.execute("CREATE TABLE words AS SELECT * FROM CSVREAD('./example.csv')");
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM words");

        JSONArray result1=resultSet2JdbcWithoutJOOQ(resultSet);
        System.out.println(result1);

        resultSet.close();

    }
    public void convertUsingJOOQDefaultApproach() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:mem:rs2jdbc", "user", "password");

        Statement stmt=dbConnection.createStatement();
        stmt.execute("CREATE TABLE words AS SELECT * FROM CSVREAD('./example.csv')");
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM words");

        JSONObject result1=resultSet2JdbcUsingJOOQDefaultApproach(resultSet,dbConnection);
        System.out.println(result1);

        resultSet.close();
    }
    public void convertUsingCustomisedJOOQ() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:mem:rs2jdbc", "user", "password");

        Statement stmt=dbConnection.createStatement();
        stmt.execute("CREATE TABLE words AS SELECT * FROM CSVREAD('./example.csv')");
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM words");

        JSONArray result1=resultSet2JdbcUsingCustomisedJOOQ(resultSet,dbConnection);
        System.out.println(result1);

        resultSet.close();
    }
    public static JSONArray resultSet2JdbcWithoutJOOQ(ResultSet resultSet) throws SQLException {
        ResultSetMetaData md=resultSet.getMetaData();
        int numCols= md.getColumnCount();
        List<String> colNames= IntStream.range(0,numCols)
                .mapToObj(i ->{
                    try {
                        return  md.getCatalogName(i+1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return "?";
                    }
                }).collect(Collectors.toList());
        JSONArray result=new JSONArray();
        while(resultSet.next()){
            JSONObject row =new JSONObject();
            colNames.forEach(cn ->{
                try {
                    row.put(cn,resultSet.getObject(cn));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            result.put(row);
        }
        return result;

    }
    public static JSONObject resultSet2JdbcUsingJOOQDefaultApproach(ResultSet resultSet,Connection dbConnection){
        JSONObject result=new JSONObject(DSL.using(dbConnection)
                .fetch(resultSet)
                .formatJSON());
        return result;
    }
    public static JSONArray resultSet2JdbcUsingCustomisedJOOQ(ResultSet resultSet,Connection dbConnection) throws SQLException {
        ResultSetMetaData md=resultSet.getMetaData();
        int numCols=md.getColumnCount();
        List<String> colNames=IntStream.range(0,numCols)
                .mapToObj(i ->{
                    try {
                        return md.getColumnName(i+1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return "?";
                    }
                }).collect(Collectors.toList());

        List<JSONObject> json=DSL.using(dbConnection)
                .fetch(resultSet)
                .map(new RecordMapper<Record, JSONObject>() {
                    @Override
                    public JSONObject map(Record record) {
                        JSONObject obj=new JSONObject();
                        colNames.forEach(cn -> obj.put(cn, record.get(cn)));
                        return obj;
                    }
                });
        return new JSONArray(json);

    }
}
