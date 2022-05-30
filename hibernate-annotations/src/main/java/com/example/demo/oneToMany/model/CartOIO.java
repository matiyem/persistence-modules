package com.example.demo.oneToMany.model;

import javax.persistence.*;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 9:13 AM
**/
@Entity
@Table(name = "CARTOIO")
public class CartOIO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "cart_id")
    private Set<ItemOIO> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ItemOIO> getItems() {
        return items;
    }

    public void setItems(Set<ItemOIO> items) {
        this.items = items;
    }
}
