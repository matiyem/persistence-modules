package com.example.persistence.savePerformance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 9/4/2021
 * Time: 3:02 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String author;
    public Book(final String title, final String author) {
        this.title = title;
        this.author = author;
    }
}
