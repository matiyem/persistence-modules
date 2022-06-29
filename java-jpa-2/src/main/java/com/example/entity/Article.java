package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 10:30 AM
**/
@Entity(name = "MyArticle")
@Table(name = Article.TABLE_NAME)
public class Article {

    public static final String TABLE_NAME = "ARTICLES";

}
