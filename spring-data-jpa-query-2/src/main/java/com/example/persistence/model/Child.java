package com.example.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 9:42 AM
 */
@Entity
@Data
public class Child implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "child")
    private Parent parent;

    public Child(){
        super();
    }
    public void setParent(final Parent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Child [id=").append(id).append("]");
        return builder.toString();
    }

}
