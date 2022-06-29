package com.example.criteria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Create by Atiye Mousavi 
    Date: 6/25/2022
    Time: 3:32 PM
**/
@Table(name = "item")
@Entity
public class Item {
    @Id
    private Long id;
    private String color;
    private String grade;
    private String name;

    public String getColor() {
        return color;
    }

    public String getGrade() {
        return grade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
