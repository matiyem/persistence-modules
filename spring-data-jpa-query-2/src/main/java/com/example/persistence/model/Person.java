package com.example.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 9:58 AM
 */

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
