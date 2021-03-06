package com.example.multipleTables.secondaryTable;

import javax.persistence.*;
import java.math.BigDecimal;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 10:43 AM
**/
@Entity
@Table(name = "meal")
@SecondaryTable(name = "allergens", pkJoinColumns = @PrimaryKeyJoinColumn(name = "meal_id"))
public class MealAsSingleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "peanuts", table = "allergens")
    private boolean peanuts;

    @Column(name = "celery", table = "allergens")
    private boolean celery;

    @Column(name = "sesame_seeds", table = "allergens")
    private boolean sesameSeeds;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPeanuts() {
        return peanuts;
    }

    public void setPeanuts(boolean peanuts) {
        this.peanuts = peanuts;
    }

    public boolean isCelery() {
        return celery;
    }

    public void setCelery(boolean celery) {
        this.celery = celery;
    }

    public boolean isSesameSeeds() {
        return sesameSeeds;
    }

    public void setSesameSeeds(boolean sesameSeeds) {
        this.sesameSeeds = sesameSeeds;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MealAsSingleEntity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", peanuts=" + peanuts + ", celery=" + celery + ", sesameSeeds=" + sesameSeeds + "]";
    }

}
