package com.example.demo.whereJoinTable;

import org.h2.engine.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 11:24 AM
**/
@Entity(name = "e_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "groups")
    private List<User> users=new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public String toString() {
        return "Group [name=" + name + "]";
    }
}
