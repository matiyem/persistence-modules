package com.example.criteria;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/25/2022
    Time: 3:31 PM
**/
public interface CustomItemRepository {

    List<Item> findItemsByColorAndGrade();

    List<Item> findItemByColorOrGrade();
}
