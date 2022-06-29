package com.example.generateIdValue;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 10:31 AM
**/
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_gen")
    @SequenceGenerator(name = "article_gen", sequenceName = "article_seq")
    private Long id;

    @Column(name = "article_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}