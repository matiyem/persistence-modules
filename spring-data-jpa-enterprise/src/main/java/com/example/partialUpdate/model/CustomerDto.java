package com.example.partialUpdate.model;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:27 PM
 */

public class CustomerDto {
    private long id;
    public String name;
    public String phone;
    //...
    private String phone99;

    public CustomerDto(long id) {
        this.id = id;
    }

    public CustomerDto(Customer c) {
        this.id = c.id;
        this.name = c.name;
        this.phone = c.phone;
    }

    public long getId() {
        return this.id;
    }

    public Customer convertToEntity() {
        Customer c = new Customer();
        c.id = id;
        c.name = name;
        c.phone = phone;
        return c;
    }
}
