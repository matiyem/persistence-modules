package com.example.exists;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:42 PM
**/
@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;
    private Integer power;
    private String model;

    public Car() {
    }
    public Car(int power, String model) {
        this.power = power;
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }
}
