package com.example.jdbcRowSet;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

/*
    Create by Atiye Mousavi 
    Date: 5/31/2022
    Time: 10:30 AM
**/
public class ExampleListener implements RowSetListener {
    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("ExampleListener alerted of cursorMoved event");
        System.out.println(event.toString());
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("ExampleListener alerted of rowChanged event");
        System.out.println(event.toString());
    }

    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("ExampleListener alerted of rowSetChanged event");
        System.out.println(event.toString());
    }
}
