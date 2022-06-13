package com.example.exception.persistentObject.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 1:54 PM
**/
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Article> articles;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticles(List<Article> articles) {
        this.articles = articles;
        articles.forEach(article -> article.setAuthor(this));
    }

}
