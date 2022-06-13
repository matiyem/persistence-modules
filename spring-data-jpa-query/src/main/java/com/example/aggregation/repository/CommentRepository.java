package com.example.aggregation.repository;

import com.example.aggregation.model.Comment;
import com.example.aggregation.model.custom.CommentCount;
import com.example.aggregation.model.custom.ICommentCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 1:11 PM
**/
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query("SELECT c.year, COUNT(c.year) FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
    List<Object[]> countTotalCommentsByYear();

    @Query("SELECT new com.example.aggregation.model.custom.CommentCount(c.year, COUNT(c.year)) FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
    List<CommentCount> countTotalCommentsByYearClass();

    @Query("SELECT c.year AS yearComment, COUNT(c.year) AS totalComment FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
    List<ICommentCount> countTotalCommentsByYearInterface();

    @Query(value = "SELECT c.year AS yearComment, COUNT(c.*) AS totalComment FROM comment AS c GROUP BY c.year ORDER BY c.year DESC", nativeQuery = true)
    List<ICommentCount> countTotalCommentsByYearNative();
}
