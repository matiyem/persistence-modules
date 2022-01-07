package com.example.partialUpdate.model;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:27 PM
 */

@Entity
public class ContactPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable=false)
    public long customerId;
    public String phone;

    @Override
    public String toString() {
        return phone;
    }
}
