package com.example.jpa.basicAnnotation;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 12:39 PM
**/
@Entity
public class Course {

    @Id
    private int id;

    @Basic(optional = false, fetch = FetchType.LAZY)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}