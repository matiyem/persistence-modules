package com.example.spring.data.jpa.query.specifications.join;

/*
    created by Atiye Mousavi
    Date: 6/16/2022
    Time: 2:55 PM
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
