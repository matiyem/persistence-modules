package com.example.demo.immutabale.util;

import com.example.demo.immutabale.entities.Event;
import com.example.demo.immutabale.entities.EventGeneratedId;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.cfg.Configuration;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 1:01 PM
**/
public class HibernateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Event.class);
            configuration.addAnnotatedClass(EventGeneratedId.class);
            configuration.configure("immutable.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            LOGGER.debug("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
