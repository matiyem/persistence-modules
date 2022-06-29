package com.example.projections;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 11:02 AM
**/
@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal unitPrice;

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

}
