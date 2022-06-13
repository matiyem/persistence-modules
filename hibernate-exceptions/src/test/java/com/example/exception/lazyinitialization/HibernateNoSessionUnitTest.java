package com.example.exception.lazyinitialization;

import com.example.exception.lazyInitialization.HibernateUtil;
import com.example.exception.lazyInitialization.entity.Role;
import com.example.exception.lazyInitialization.entity.User;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class HibernateNoSessionUnitTest {

    private static SessionFactory sessionFactory;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Test
    public void whenAccessUserRolesInsideSession_thenSuccess() {

        User detachedUser = createUserWithRoles();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User persistentUser = session.find(User.class, detachedUser.getId());

        Assert.assertEquals(2, persistentUser.getRoles().size());

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void whenAccessUserRolesOutsideSession_thenThrownException() {

        User detachedUser = createUserWithRoles();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User persistentUser = session.find(User.class, detachedUser.getId());

        session.getTransaction().commit();
        session.close();

        thrown.expect(LazyInitializationException.class);
        System.out.println(persistentUser.getRoles().size());
    }

    private User createUserWithRoles() {

        Role admin = new Role("Admin");
        Role dba = new Role("DBA");

        User user = new User("Bob", "Smith");

        user.addRole(admin);
        user.addRole(dba);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user.getRoles().forEach(role -> session.save(role));
        session.save(user);
        session.getTransaction().commit();
        session.close();

        return user;
    }

    @AfterClass
    public static void cleanUp() {
        sessionFactory.close();
    }
}
