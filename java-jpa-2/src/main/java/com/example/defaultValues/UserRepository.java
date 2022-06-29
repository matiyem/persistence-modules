package com.example.defaultValues;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
    Create by Atiye Mousavi 
    Date: 6/26/2022
    Time: 10:09 AM
**/
public class UserRepository {

    private EntityManagerFactory emf=null;

    public UserRepository(){
        emf= Persistence.createEntityManagerFactory("entity-default-values");
    }
    public User find(Long id){
        EntityManager entityManager= emf.createEntityManager();
        User user=entityManager.find(User.class,id);
        entityManager.close();
        return user;

    }
    public void save(User user,Long id){
        user.setId(id);

        EntityManager entityManager= emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void clean(){
        emf.close();
    }
}
