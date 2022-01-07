package com.example.spring.data.jpa.query;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 10:02 AM
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate creationDate;
    private LocalDate lastLoginDate;
    private boolean active;
    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    private Integer status;
    public User() {
        super();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [name=").append(name).append(", id=").append(id).append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(creationDate, user.creationDate) &&
                Objects.equals(email, user.email) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, age, email, status);
    }


}
