package com.example.persistence.audit;

import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarService;
import com.example.spring.config.PersistenceTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * created by Atiye Mousavi
 * Date: 9/8/2021
 * Time: 3:53 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)//این برای ساخت application context است
//برای لود کردن application context است

//ورودی classes برای لود کردن applicationContext است
//ورودی inheritInitializers برای مشخص کردن superClass است
//وروودی inheritLocations برای مشخص کردن این است که آیا resource ها یا componrnt ها از superClass های Test ارث بری کرده اند یا خیر
//ورودی initializers برای initializ کردن ConfigurableApplicationContext. است
//ورودی loader برای مشخص کردن نوع تایپی از  SmartContextLoader یا ContextLoader برای لود کردن applicationContext است
//ورودی locations برای مشخص کردن مسیر لود کردن applicationContext
//ورودی name برای مشخص کردن context hierarchy است
@ContextConfiguration(classes = { PersistenceTestConfig.class }, loader = AnnotationConfigContextLoader.class)

@Slf4j
public class SpringDataJPABarAuditIntegrationTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        log.info("setUpBeforeClass()");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        log.info("tearDownAfterClass()");
    }

    @Autowired
    @Qualifier("barSpringDataJpaService")
    private IBarService barService;

    @Autowired
    @Qualifier("jpaEntityManager")
    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        log.info("setUp()");
        em = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        log.info("tearDown()");
        em.close();
    }

    @Test
    @WithMockUser(username = "tutorialuser")//برای تست security است
    public final void whenBarsModified_thenBarsAudited() {
        Bar bar = new Bar("BAR1");
        barService.create(bar);
        assertEquals(bar.getCreatedDate(), bar.getModifiedDate());
        assertEquals("tutorialuser", bar.getCreatedBy(), bar.getModifiedBy());
        bar.setName("BAR2");
        bar = barService.update(bar);
        assertTrue(bar.getCreatedDate() < bar.getModifiedDate());
        assertEquals("tutorialuser", bar.getCreatedBy(), bar.getModifiedBy());
    }
}
