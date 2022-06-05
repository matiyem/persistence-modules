package com.example.statmentVsPreparedstatment;

import java.util.Objects;

/*
    Create by Atiye Mousavi 
    Date: 5/31/2022
    Time: 1:23 PM
**/
public class PersonEntity {
    private int id;
    private String name;
    public PersonEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(id, name);
    }
}
