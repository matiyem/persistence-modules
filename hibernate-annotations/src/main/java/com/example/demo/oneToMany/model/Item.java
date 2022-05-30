package com.example.demo.oneToMany.model;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 9:08 AM
**/
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    public Item(Cart c) {
        this.cart = c;
    }
    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
