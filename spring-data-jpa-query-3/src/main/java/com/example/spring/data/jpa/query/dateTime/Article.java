package com.example.spring.data.jpa.query.dateTime;

/*
    created by Atiye Mousavi
    Date: 6/16/2022
    Time: 2:38 PM
*/


import javax.persistence.*;
import java.util.Date;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Temporal(TemporalType.TIME)
    private Date publicationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    public Integer getId() {
        return id;
    }

}