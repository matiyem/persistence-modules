package com.example.entityNotFoundException;

import javax.persistence.*;
import java.io.Serializable;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 9:33 AM
**/
@Entity
public class Item implements Serializable {

    @Id
    @Column(unique = true,nullable = false)
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
