package com.example.jdbcRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import com.sun.rowset.WebRowSetImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.rowset.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

/*
    Create by Atiye Mousavi 
    Date: 5/31/2022
    Time: 10:52 AM
**/
@SpringBootApplication
public class JdbcRowsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcRowsetApplication.class,args);
        Statement stmt=null;

        try {
            Connection conn=DatabaseConfiguration.geth2Connection();

            String drop="DROP TABLE IF EXISTS customers, associates;";
            String schema = "CREATE TABLE customers (id INT NOT NULL, name VARCHAR(50) NOT NULL, PRIMARY KEY (id)); ";
            String schemapartb = "CREATE TABLE associates (id INT NOT NULL, name VARCHAR(50) NOT NULL, PRIMARY KEY (id));";

            stmt=conn.createStatement();
            stmt.executeUpdate(drop);
            stmt.executeUpdate(schema);
            stmt.executeUpdate(schemapartb);

            DatabaseConfiguration.initDatabase(stmt);

            String sql = "SELECT * FROM customers";
            JdbcRowSet jdbcRS;
            jdbcRS=new JdbcRowSetImpl(conn);
            jdbcRS.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            jdbcRS.setCommand(sql);
            jdbcRS.execute();
            jdbcRS.addRowSetListener(new ExampleListener());

            while(jdbcRS.next()){
                System.out.println("id=" + jdbcRS.getString(1));
                System.out.println("name=" + jdbcRS.getString(2));
            }
            String username="sa";
            String password="";
            String url = "jdbc:h2:mem:testdb";
            CachedRowSet crs=new CachedRowSetImpl();
            crs.setUsername(username);
            crs.setPassword(password);
            crs.setUrl(url);
            crs.setCommand(sql);
            crs.execute();
            crs.addRowSetListener(new ExampleListener());
            while(crs.next()){
                if (crs.getInt("id")==1){
                    System.out.println("CRS found customer1 and will remove the record.");
                    crs.deleteRow();
                    break;
                }
            }

            WebRowSet wrs=new WebRowSetImpl();
            wrs.setUsername(username);
            wrs.setPassword(password);
            wrs.setUrl(url);
            wrs.setCommand(sql);
            wrs.execute();
            FileOutputStream ostream=new FileOutputStream("customer.xml");
            wrs.writeXml(ostream);

            CachedRowSetImpl customers=new CachedRowSetImpl();
            customers.setUsername(username);
            customers.setPassword(password);
            customers.setUrl(url);
            customers.setCommand(sql);
            customers.execute();

            CachedRowSetImpl associates=new CachedRowSetImpl();
            associates.setUsername(username);
            associates.setPassword(password);
            associates.setUrl(url);
            String associatesSQL = "SELECT * FROM associates";
            associates.setCommand(associatesSQL);
            associates.execute();

            JoinRowSet jrs=new JoinRowSetImpl();
            final String ID="id";
            final String NAME="name";
            jrs.addRowSet(customers,ID);
            jrs.addRowSet(associates,ID);
            jrs.last();
            System.out.println("Total rows: " + jrs.getRow());
            jrs.beforeFirst();
            while(jrs.next()){
                String string1 = jrs.getString(ID);
                String string2 = jrs.getString(NAME);
                System.out.println("ID: " + string1 + ", NAME: " + string2);
            }
            RowSetFactory rsf=RowSetProvider.newFactory();
            FilteredRowSet frs=rsf.createFilteredRowSet();
            frs.setCommand("select * from customers");
            frs.execute(conn);
            frs.setFilter(new FilterExample("^[A-C].*"));
            ResultSetMetaData rsmd = frs.getMetaData();
            int columncount = rsmd.getColumnCount();
            while (frs.next()) {
                for (int i = 1; i <= columncount; i++) {
                    System.out.println(rsmd.getColumnLabel(i) + " = " + frs.getObject(i) + " ");
                }
            }







        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
