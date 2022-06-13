package com.example.entityGraph.repository;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:29 PM
**/

import com.example.entityGraph.model.Characteristic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicsRepository extends JpaRepository<Characteristic,Long> {

    @EntityGraph(attributePaths = {"item"})
    Characteristic findByType(String type);
}
