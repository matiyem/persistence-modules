package com.example.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 9:44 AM
 */
@Entity
@Data
public class Parent implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "child_fk")
    private Child child;

    public Parent() {
        super();
    }

    public Parent(final Child child) {
        super();

        this.child = child;
    }
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Parent [id=").append(id).append("]");
        return builder.toString();
    }

}
