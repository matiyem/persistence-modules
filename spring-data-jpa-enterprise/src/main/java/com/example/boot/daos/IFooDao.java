package com.example.boot.daos;

import com.example.boot.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 4:13 PM
 */
public interface IFooDao extends JpaRepository<Foo,Long> {

    @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
    Foo retrieveByName(@Param("name") String name);
}
