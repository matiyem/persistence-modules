package com.example.queryParams;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 11:49 AM
**/
@Entity
@Table(name = "employees")
public class Employee {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_number", unique = true)
    private String empNumber;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_age")
    private int age;

    public Employee() {
        super();
    }

    public Employee(Long id, String empNumber) {
        super();
        this.id = id;
        this.empNumber = empNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}