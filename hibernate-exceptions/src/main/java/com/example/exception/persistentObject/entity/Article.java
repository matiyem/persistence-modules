package com.example.exception.persistentObject.entity;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 10:25 AM
**/
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToOne(optional = false)
    private Author author;

    public Article(String title) {
        this.title = title;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }
}
