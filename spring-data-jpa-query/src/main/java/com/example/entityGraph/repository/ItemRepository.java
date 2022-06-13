package com.example.entityGraph.repository;

import com.example.entityGraph.model.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:32 PM
**/
public interface ItemRepository extends JpaRepository<Item,Long> {

    @EntityGraph(value = "Item.characteristics", type = EntityGraph.EntityGraphType.FETCH)
    Item findByName(String name);
}
