package com.example.namingStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 2:44 PM
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
