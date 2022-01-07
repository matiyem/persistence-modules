package com.example.spring.data.jpa.query.datetime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticleRepository extends JpaRepository<com.example.spring.data.jpa.query.datetime.Article, Integer> {

    List<com.example.spring.data.jpa.query.datetime.Article> findAllByPublicationDate(Date publicationDate);

    List<com.example.spring.data.jpa.query.datetime.Article> findAllByPublicationTimeBetween(Date publicationTimeStart,
                                                                                              Date publicationTimeEnd);

    @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<com.example.spring.data.jpa.query.datetime.Article> findAllWithCreationDateTimeBefore(
      @Param("creationDateTime") Date creationDateTime);

}
