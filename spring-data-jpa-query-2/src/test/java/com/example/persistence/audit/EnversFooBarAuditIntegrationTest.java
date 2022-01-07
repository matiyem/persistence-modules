package com.example.persistence.audit;

import com.example.persistence.model.Bar;
import com.example.persistence.model.Foo;
import com.example.persistence.service.IBarAuditableService;
import com.example.persistence.service.IFooAuditableService;
import com.example.spring.config.PersistenceTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 7:51 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={PersistenceTestConfig.class},loader = AnnotationConfigContextLoader.class)

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Slf4j
public class EnversFooBarAuditIntegrationTest {

    @BeforeClass
    public static void setUpBeforClass(){
        log.info("setUpBeforClass");
    }
    @AfterClass
    public static void tearDownAfterClass(){
        log.info("tearDownAfterClass()");
    }
    @Autowired
    @Qualifier("fooHibernateAuditableService")
    private IFooAuditableService fooService;

    @Autowired
    @Qualifier("barHibernateAuditableService")
    private IBarAuditableService barService;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Before
    public void setUp(){
        log.info("setUp");
        makeRevisions();
        session=sessionFactory.openSession();
    }
    @After
    public void tearDown(){
        log.info("tearDown");
        session.close();
    }
    private void makeRevisions(){
        final Bar bar=rev1();
        rev2(bar);
        rev3(bar);
        rev4(bar);
    }
    private Bar rev1(){
        final Bar bar=new Bar("BAR");
        final Foo foo1=new Foo("FOO1");
        foo1.setBar(bar);
        fooService.create(foo1);
        return bar;
    }
    private void rev2(final Bar bar){
        final Foo foo2=new Foo("FOO2");
        foo2.setBar(bar);
        fooService.create(foo2);
    }
    private void rev3(final Bar bar){
        bar.setName("BAR1");
        barService.update(bar);
    }
    private void rev4(final Bar bar){
        final Foo foo3=new Foo("FOO3");
        foo3.setBar(bar);
        fooService.create(foo3);
    }
    @Test
    public final void whenFooBarsModified_thenFooBarsAudited() {

        List<Bar> barRevisionList;
        List<Foo> fooRevisionList;

        // test Bar revisions

        barRevisionList = barService.getRevision();

        assertNotNull(barRevisionList);
        assertEquals(4, barRevisionList.size());

        assertEquals("BAR", barRevisionList.get(0).getName());
        assertEquals("BAR", barRevisionList.get(1).getName());
        assertEquals("BAR1", barRevisionList.get(2).getName());
        assertEquals("BAR1", barRevisionList.get(3).getName());

        assertEquals(1, barRevisionList.get(0).getFooSet().size());
        assertEquals(2, barRevisionList.get(1).getFooSet().size());
        assertEquals(2, barRevisionList.get(2).getFooSet().size());
        assertEquals(3, barRevisionList.get(3).getFooSet().size());

        // test Foo revisions

        fooRevisionList = fooService.getRevision();
        assertNotNull(fooRevisionList);
        assertEquals(3, fooRevisionList.size());
        assertEquals("FOO1", fooRevisionList.get(0).getName());
        assertEquals("FOO2", fooRevisionList.get(1).getName());
        assertEquals("FOO3", fooRevisionList.get(2).getName());
    }
}
