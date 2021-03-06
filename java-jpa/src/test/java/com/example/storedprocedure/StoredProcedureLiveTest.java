package com.example.storedprocedure;

import com.example.jpa.model.Car;
import org.junit.*;

import javax.persistence.*;

public class StoredProcedureLiveTest {

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("jpa-db");
        entityManager = factory.createEntityManager();
    }

    @Before
    public void setup() {
    }

    @Test
    public void createCarTest() {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            final Car car = new Car("Fiat Marea", 2015);
            entityManager.persist(car);
            transaction.commit();
        } catch (final Exception e) {
            System.out.println(e.getCause());
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Test
    public void findCarsByYearNamedProcedure() {
        final StoredProcedureQuery findByYearProcedure = entityManager.createNamedStoredProcedureQuery("findByYearProcedure");
        final StoredProcedureQuery storedProcedure = findByYearProcedure.setParameter("p_year", 2015);
        storedProcedure.getResultList()
            .forEach(c -> Assert.assertEquals(new Integer(2015), ((Car) c).getYear()));
    }

    @Test
    public void findCarsByYearNoNamed() {
        final StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("FIND_CAR_BY_YEAR", Car.class)
            .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter(2,Integer.class, ParameterMode.OUT)
            .setParameter(1, 2015);
        int output= (int) storedProcedure.getOutputParameterValue(2);

        storedProcedure.getResultList()
            .forEach(c -> Assert.assertEquals(new Integer(2015), ((Car) c).getYear()));
    }

    @AfterClass
    public static void destroy() {

        if (entityManager != null) {
            entityManager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}
