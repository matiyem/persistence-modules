package com.example.jpa.primaryKeys;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:19 PM
**/
@Entity
public class Book {
    @EmbeddedId
    private BookId bookId;

    private String description;

    public Book() {

    }

    public Book(BookId bookId) {
        this.bookId = bookId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
