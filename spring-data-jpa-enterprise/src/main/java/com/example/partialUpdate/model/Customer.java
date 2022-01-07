package com.example.partialUpdate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:26 PM
 */
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String phone;
    //...
    public String phone99;

    @Override public String toString() {
        return String.format("Customer %s, Phone: %s",
                this.name, this.phone);
    }
}
