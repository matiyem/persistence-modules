package com.example.entityNotFoundException;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 9:37 AM
**/
@Entity
public class User {

    @Id
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
