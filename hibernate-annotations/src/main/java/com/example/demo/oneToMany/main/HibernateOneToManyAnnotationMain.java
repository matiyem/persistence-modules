package com.example.demo.oneToMany.main;

import com.example.demo.oneToMany.config.HibernateAnnotationUtil;
import com.example.demo.oneToMany.model.Cart;
import com.example.demo.oneToMany.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 11:00 AM
**/
public class HibernateOneToManyAnnotationMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateOneToManyAnnotationMain.class);

    public static void main(String[] args) {
        Cart cart = new Cart();


        Item item1 = new Item(cart);
        Item item2 = new Item(cart);
        Set<Item> itemsSet = new HashSet<>();
        itemsSet.add(item1);
        itemsSet.add(item2);

        cart.setItems(itemsSet);

        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        LOGGER.info("Session created");

        try {
            Transaction tx = session.beginTransaction();

            session.save(cart);
            session.save(item1);
            session.save(item2);

            tx.commit();

            LOGGER.info("Cart ID={}", cart.getId());
            LOGGER.info("item1 ID={}, Foreign Key Cart ID={}", item1.getId(), item1.getCart().getId());
            LOGGER.info("item2 ID={}, Foreign Key Cart ID={}", item2.getId(), item2.getCart().getId());


        } catch (Exception e) {
            LOGGER.error("Exception occurred", e);

        } finally {
            if (!sessionFactory.isClosed()){
                LOGGER.info("Closing SessionFactory");
                sessionFactory.close();
            }

        }

    }
}
