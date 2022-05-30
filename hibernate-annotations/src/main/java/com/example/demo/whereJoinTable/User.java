package com.example.demo.whereJoinTable;

import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 11:28 AM
**/
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "r_user_group",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups=new ArrayList<>();

    @WhereJoinTable(clause = "role='MODERATOR'")
    @ManyToMany
    @JoinTable(name = "r_user_group",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> moderatorGroups=new ArrayList<>();

    public User(String name) {
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getModeratorGroups() {
        return moderatorGroups;
    }

    public void setModeratorGroups(List<Group> moderatorGroups) {
        this.moderatorGroups = moderatorGroups;
    }
    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }

}
