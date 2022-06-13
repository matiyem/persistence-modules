package com.example.exception.lazyInitialization.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 10:08 AM
**/
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Role> roles=new HashSet<>();

    public User() {

    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

}
