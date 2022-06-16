package com.example.spring.data.jpa.entity;

/*
    created by Atiye Mousavi
    Date: 6/16/2022
    Time: 2:37 PM
*/


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Long salary;

}