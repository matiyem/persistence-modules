package com.example.boot.passenger;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 6/7/2022
    Time: 2:19 PM
**/
@Repository
public class PassengerRepositoryImpl implements CustomPassengerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Passenger> findOrderedBySeatNumberLimitedTo(int limit) {
        return entityManager.createQuery("SELECT p FROM Passenger p ORDER BY p.seatNumber",
                Passenger.class).setMaxResults(limit).getResultList();    }
}
