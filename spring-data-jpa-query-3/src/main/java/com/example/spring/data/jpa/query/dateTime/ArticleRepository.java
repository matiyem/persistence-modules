package com.example.spring.data.jpa.query.dateTime;

/*
    created by Atiye Mousavi
    Date: 6/16/2022
    Time: 2:38 PM
*/


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findAllByPublicationDate(Date publicationDate);

    List<Article> findAllByPublicationTimeBetween(Date publicationTimeStart,
                                                  Date publicationTimeEnd);

    @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<Article> findAllWithCreationDateTimeBefore(
            @Param("creationDateTime") Date creationDateTime);

}