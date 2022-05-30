package com.example.demo.joinColumn;

import com.example.demo.customTypes.OfficeEmployee;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 1:52 PM
**/
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private OfficialEmployee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OfficialEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(OfficialEmployee employee) {
        this.employee = employee;
    }

}
