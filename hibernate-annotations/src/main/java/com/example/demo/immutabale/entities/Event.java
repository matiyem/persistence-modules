package com.example.demo.immutabale.entities;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 11:23 AM
**/
@Entity
@Immutable
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @Immutable
    private Set<String> guestList;

    public Event() {
    }

    public Event(Long id, String title, Set<String> guestList) {
        this.id = id;
        this.title = title;
        this.guestList = guestList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE })
    public Set<String> getGuestList() {
        return guestList;
    }

    public void setGuestList(Set<String> guestList) {
        this.guestList = guestList;
    }
}
