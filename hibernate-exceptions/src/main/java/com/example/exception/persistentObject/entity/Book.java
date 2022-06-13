package com.example.exception.persistentObject.entity;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 3:00 PM
**/
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
