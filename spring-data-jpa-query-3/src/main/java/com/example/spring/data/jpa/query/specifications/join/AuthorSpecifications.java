package com.example.spring.data.jpa.query.specifications.join;

/*
    created by Atiye Mousavi
    Date: 6/16/2022
    Time: 2:40 PM
*/


import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class AuthorSpecifications {

    public static Specification<Author> hasFirstNameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.<String>get("firstName"), "%" + name + "%");
    }

    public static Specification<Author> hasLastName(String name) {
        return (root, query, cb) -> cb.equal(root.<String>get("lastName"), name);
    }

    public static Specification<Author> hasBookWithTitle(String bookTitle) {
        return (root, query, criteriaBuilder) -> {
            Join<Book, Author> authorsBook = root.join("books");
            return criteriaBuilder.equal(authorsBook.get("title"), bookTitle);
        };
    }

}