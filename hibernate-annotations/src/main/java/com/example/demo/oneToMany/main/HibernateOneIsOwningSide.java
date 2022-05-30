package com.example.demo.oneToMany.main;

import com.example.demo.oneToMany.config.HibernateAnnotationUtil;
import com.example.demo.oneToMany.model.CartOIO;
import com.example.demo.oneToMany.model.ItemOIO;
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
    Time: 9:50 AM
**/
public class HibernateOneIsOwningSide {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateOneIsOwningSide.class);

    public static void main(String[] args) {
        CartOIO cart = new CartOIO();
        CartOIO cart2 = new CartOIO();

        ItemOIO item1 = new ItemOIO(cart);
        ItemOIO item2 = new ItemOIO(cart2);

        Set<ItemOIO> itemsSet = new HashSet<>();
        itemsSet.add(item1);
        itemsSet.add(item2);

        cart.setItems(itemsSet);

        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Session created");

        Transaction tx;

        try {
            tx = session.beginTransaction();

            session.save(cart);
            session.save(cart2);
            session.save(item1);
            session.save(item2);

            tx.commit();

            session = sessionFactory.getCurrentSession();
            tx.commit();

            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            item1 = session.get(ItemOIO.class, 1L);
            item2 = session.get(ItemOIO.class, 2L);
            tx.commit();

            LOGGER.info("item1 ID={}, Foreign Key CartOIO ID={}", item1.getId(), item1.getCartOIO().getId());
            LOGGER.info("item2 ID={}, Foreign Key CartOIO ID={}", item2.getId(), item2.getCartOIO().getId());

        } catch (Exception e) {
            LOGGER.error("Exception occurred", e);

        }finally {
            if (!sessionFactory.isClosed()){
                LOGGER.info("Closing SessionFactory");
                sessionFactory.close();
            }
        }

    }
}
