package com.example.demo.oneToMany.model;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 9:15 AM
**/
@Entity
@Table(name = "ITEMSOIO")
public class ItemOIO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id",insertable = false,updatable = false)
    private CartOIO cart;

    public ItemOIO(CartOIO c) {
        this.cart = c;
    }

    public ItemOIO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CartOIO getCart() {
        return cart;
    }

    public void setCart(CartOIO cart) {
        this.cart = cart;
    }
    public CartOIO getCartOIO() {
        return cart;
    }
}
