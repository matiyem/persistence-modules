package com.example.multipletables;

import com.example.multipleTables.multipleEntities.MealWithMultipleEntities;
import com.example.multipleTables.secondaryTable.MealAsSingleEntity;
import com.example.multipleTables.secondaryTable.embeddable.MealWithEmbeddedAllergens;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleTablesIntegrationTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("jpa-h2-multipltables");
        em = emf.createEntityManager();
    }

    @Test
    public void entityManager_shouldLoadMealAsSingleEntity() {
        // given
        
        // when
        MealAsSingleEntity meal = em.find(MealAsSingleEntity.class, 1L);
        
        // then
        assertThat(meal).isNotNull();
        assertThat(meal.getId()).isEqualTo(1L);
        assertThat(meal.isPeanuts()).isFalse();
        assertThat(meal.isCelery()).isTrue();
    }

    @Test
    public void entityManager_shouldLoadMealWithEmbeddedAllergens() {
        // given
        
        // when
        MealWithEmbeddedAllergens meal = em.find(MealWithEmbeddedAllergens.class, 1L);
        
        // then
        assertThat(meal).isNotNull();
        assertThat(meal.getId()).isEqualTo(1L);
        assertThat(meal.getAllergens()).isNotNull();
        assertThat(meal.getAllergens().isPeanuts()).isFalse();
        assertThat(meal.getAllergens().isCelery()).isTrue();
    }

    @Test
    public void entityManager_shouldLoadMealWithAllergensEntity() {
        // given
        
        // when
        MealWithMultipleEntities meal = em.find(MealWithMultipleEntities.class, 1L);
        
        // then
        assertThat(meal).isNotNull();
        assertThat(meal.getId()).isEqualTo(1L);
        assertThat(meal.getAllergens()).isNotNull();
        assertThat(meal.getAllergens().isPeanuts()).isFalse();
        assertThat(meal.getAllergens().isCelery()).isTrue();
    }

    @AfterClass
    public static void teardown() {
        if (emf != null) {
            emf.close();
        }
    }

}
