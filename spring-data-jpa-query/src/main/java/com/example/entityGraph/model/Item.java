package com.example.entityGraph.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:26 PM
**/
@Entity
@NamedEntityGraph(name = "Item.characteristics",
attributeNodes = @NamedAttributeNode("characteristics"))
public class Item {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "item")
    private List<Characteristic> characteristics = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
