package com.example.entityNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 9:27 AM
**/
@Entity
public class Category implements Serializable {

    @Id
    @Column(unique = true,nullable = false)
    private long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "category_id",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Item> items=new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
