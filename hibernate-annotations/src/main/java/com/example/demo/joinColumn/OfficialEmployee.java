package com.example.demo.joinColumn;

import javax.persistence.*;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 2:01 PM
**/
@Entity
public class OfficialEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    private List<Email> emails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
