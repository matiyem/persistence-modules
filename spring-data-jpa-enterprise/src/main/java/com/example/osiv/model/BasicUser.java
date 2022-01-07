package com.example.osiv.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:01 PM
 */
@Entity
@Table(name = "basic_users")
@Data
public class BasicUser {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    //Similar to other one-to-many and many-to-many relationships, the permissions property is
    // a lazy collection.
    //در لایه سرویس وقتی از این entity استفاده میشود باید با Transactional@ استفاده شود
    @ElementCollection
    private Set<String> permissions;

}
