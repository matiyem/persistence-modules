package com.example.persistence.service;

import com.example.config.PersistenceConfig;
import com.example.persistence.model.Foo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
@Slf4j
public class FooStoredProceduresLiveTest {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("fooHibernateService")
    private IFooService fooService;

    private Session session;

    @Before
    public final void before() {
        session = sessionFactory.openSession();
        Assume.assumeTrue(getAllFoosExists());
        Assume.assumeTrue(getFoosByNameExists());
    }

    private boolean getFoosByNameExists() {
        try {
            //برای کال کردن یک sp است
            Query sqlQuery = session.createSQLQuery("CALL GetAllFoos()").addEntity(Foo.class);
            sqlQuery.list();
            return true;
        } catch (SQLGrammarException e) {
            log.error("WARNING : GetFoosByName() Procedure is may be missing ", e);
            return false;
        }
    }

    private boolean getAllFoosExists() {
        try {
            //برای اینکه ورودی به sp بدهیم به روش زیر استفاده میکنیم
            //Query query = session.createSQLQuery("CALL GetFoosByName(:fooName)")
            //  .addEntity(Foo.class)
            //  .setParameter("fooName","New Foo");
            Query sqlQuery = session.createSQLQuery("CALL GetAllFoos()").addEntity(Foo.class);
            sqlQuery.list();
            return true;
        } catch (SQLGrammarException e) {
            log.error("WARNING : GetAllFoos() Procedure is may be missing ", e);
            return false;
        }
    }

    @After
    public final void after() {
        session.close();
    }

    @Test
    public final void getAllFoosUsingStoredProcedures() {

        fooService.create(new Foo(randomAlphabetic(6)));

        // Stored procedure getAllFoos using createSQLQuery
        Query sqlQuery = session.createSQLQuery("CALL GetAllFoos()").addEntity(Foo.class);
        @SuppressWarnings("unchecked")
        List<Foo> allFoos = sqlQuery.list();
        for (Foo foo : allFoos) {
            log.info("getAllFoos() SQL Query result : {}", foo.getName());
        }
        assertEquals(allFoos.size(), fooService.findAll().size());

        // Stored procedure getAllFoos using a Named Query
        Query namedQuery = session.getNamedQuery("callGetAllFoos");
        @SuppressWarnings("unchecked")
        List<Foo> allFoos2 = namedQuery.list();
        for (Foo foo : allFoos2) {
            log.info("getAllFoos() NamedQuery result : {}", foo.getName());
        }
        assertEquals(allFoos2.size(), fooService.findAll().size());
    }

    @Test
    public final void getFoosByNameUsingStoredProcedures() {

        fooService.create(new Foo("NewFooName"));

        // Stored procedure getFoosByName using createSQLQuery()
        Query sqlQuery = session.createSQLQuery("CALL GetFoosByName(:fooName)").addEntity(Foo.class).setParameter("fooName", "NewFooName");
        @SuppressWarnings("unchecked")
        List<Foo> allFoosByName = sqlQuery.list();
        for (Foo foo : allFoosByName) {
            log.info("getFoosByName() using SQL Query : found => {}", foo.toString());
        }

        // Stored procedure getFoosByName using getNamedQuery()
        Query namedQuery = session.getNamedQuery("callGetFoosByName").setParameter("fooName", "NewFooName");
        @SuppressWarnings("unchecked")
        List<Foo> allFoosByName2 = namedQuery.list();
        for (Foo foo : allFoosByName2) {
            log.info("getFoosByName() using Native Query : found => {}", foo.toString());
        }

    }
}
