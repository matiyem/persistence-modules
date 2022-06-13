package com.example.exception.persistentObject;

import com.example.exception.persistentObject.entity.Article;
import com.example.exception.persistentObject.entity.Author;
import com.example.exception.persistentObject.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/*
    Create by Atiye Mousavi 
    Date: 6/11/2022
    Time: 3:02 PM
**/
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if (sessionFactory ==null){
            try {
                Configuration configuration=new Configuration();
                Properties setting=new Properties();

                setting.put(Environment.DRIVER,"org.hsqldb.jdbcDriver");
                setting.put(Environment.URL,"jdbc:hsqldb:mem:userrole");
                setting.put(Environment.USER,"sa");
                setting.put(Environment.PASS,"");
                setting.put(Environment.DIALECT,"org.hibernate.dialect.HSQLDialect");
                setting.put(Environment.SHOW_SQL,"true");
                setting.put(Environment.HBM2DDL_AUTO,"update");
                setting.put(Environment.CHECK_NULLABILITY,"true");

                configuration.setProperties(setting);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Article.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
