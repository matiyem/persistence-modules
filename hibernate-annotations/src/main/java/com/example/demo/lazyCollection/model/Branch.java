package com.example.demo.lazyCollection.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 2:20 PM
**/
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "mainBranch")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Employee> mainEmployees;

    @OneToMany(mappedBy = "subBranch")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Employee> subEmployees;

    @OneToMany(mappedBy = "additionalBranch")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OrderColumn(name = "order_id")
    private List<Employee> additionalEmployees;


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

    public List<Employee> getMainEmployees() {
        return mainEmployees;
    }

    public void setMainEmployees(List<Employee> mainEmployees) {
        this.mainEmployees = mainEmployees;
    }

    public List<Employee> getSubEmployees() {
        return subEmployees;
    }

    public void setSubEmployees(List<Employee> subEmployees) {
        this.subEmployees = subEmployees;
    }

    public List<Employee> getAdditionalEmployees() {
        return additionalEmployees;
    }

    public void setAdditionalEmployees(List<Employee> additionalEmployees) {
        this.additionalEmployees = additionalEmployees;
    }
    public void addMainEmployee(Employee employee) {
        if (this.mainEmployees == null) {
            this.mainEmployees = new ArrayList<>();
        }
        this.mainEmployees.add(employee);
    }

    public void addSubEmployee(Employee employee) {
        if (this.subEmployees == null) {
            this.subEmployees = new ArrayList<>();
        }
        this.subEmployees.add(employee);
    }

    public void addAdditionalEmployee(Employee employee) {
        if (this.additionalEmployees == null) {
            this.additionalEmployees = new ArrayList<>();
        }
        this.additionalEmployees.add(employee);
    }
}


