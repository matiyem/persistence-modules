package com.example.demo.joinColumn;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 1:59 PM
**/
@Entity
public class OfficeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ZIP")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
