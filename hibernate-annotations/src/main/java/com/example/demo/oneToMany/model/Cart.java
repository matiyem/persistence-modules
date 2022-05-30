package com.example.demo.oneToMany.model;

import javax.persistence.*;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 9:06 AM
**/
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
