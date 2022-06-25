package com.example.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 1:56 PM
**/
@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
    private String name;
    @Transient
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}