package com.example.persistence.audit;

import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarService;
import com.example.spring.config.PersistenceTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.*;

/**
 * created by Atiye Mousavi
 * Date: 9/8/2021
 * Time: 2:43 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class},loader = AnnotationConfigContextLoader.class)
@Slf4j
public class JPABarAuditIntegrationTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        log.info("setUpBeforeClass()");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        log.info("tearDownAfterClass()");
    }

    @Autowired
    @Qualifier("barJpaService")
    private IBarService barService;

    @Autowired
    @Qualifier("jpaEntityManager")
    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;

    @Before
    public void setUp(){
        log.info("setUp()");
        em=entityManagerFactory.createEntityManager();
    }
    @After
    public void tearDown(){
        log.info("tearDown()");
        em.clear();
    }
    @Test
    public final void whenBarsModified_thenBarsAudited(){
        // insert BAR1
        Bar bar1 = new Bar("BAR1");
        barService.create(bar1);

        // update BAR1
        bar1.setName("BAR1a");
        barService.update(bar1);

        // insert BAR2
        Bar bar2 = new Bar("BAR2");
        barService.create(bar2);

        // update BAR1
        bar1.setName("BAR1b");
        barService.update(bar1);

        // get BAR1 and BAR2 from the DB and check the audit values
        // detach instances from persistence context to make sure we fire db
        em.detach(bar1);
        em.detach(bar2);
        bar1 = barService.findOne(bar1.getId());
        bar2 = barService.findOne(bar2.getId());

        assertNotNull(bar1);
        assertNotNull(bar2);
        assertEquals(Bar.OPERATION.UPDATE, bar1.getOperation());
        assertEquals(Bar.OPERATION.INSERT, bar2.getOperation());
        assertTrue(bar1.getTimestamp() > bar2.getTimestamp());

        barService.deleteById(bar1.getId());
        barService.deleteById(bar2.getId());
    }
}
