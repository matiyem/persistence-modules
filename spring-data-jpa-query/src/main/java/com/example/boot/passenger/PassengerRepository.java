package com.example.boot.passenger;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:18 PM
**/
interface PassengerRepository extends JpaRepository<Passenger, Long>, CustomPassengerRepository {
    Passenger findFirstByOrderBySeatNumberAsc();

    Passenger findTopByOrderBySeatNumberAsc();

    List<Passenger> findByOrderBySeatNumberAsc();

    List<Passenger> findByFirstNameIgnoreCase(String firstName);

    List<Passenger> findByLastNameOrderBySeatNumberAsc(String lastName);

    List<Passenger> findByLastName(String lastName, Sort sort);
}
