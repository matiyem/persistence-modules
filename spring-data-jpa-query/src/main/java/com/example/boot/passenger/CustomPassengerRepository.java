package com.example.boot.passenger;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 1:17 PM
**/
public interface CustomPassengerRepository {

   public List<Passenger> findOrderedBySeatNumberLimitedTo(int limit);
}
