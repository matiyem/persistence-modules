package com.example.persistence.service;

import com.example.persistence.model.Child;
import com.example.persistence.model.Parent;
import com.example.spring.config.PersistenceTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ParentServicePersistenceIntegrationTest {

    @Autowired
    private IParentService service;

    @Autowired
    private IChildService childService;

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenNoExceptions() {
        //
    }

    @Test
    public final void whenOneToOneEntitiesAreCreated_thenNoExceptions() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        System.out.println("Child = " + childService.findOne(childEntity.getId()));
        System.out.println("Child - parent = " + childService.findOne(childEntity.getId()).getParent());

        System.out.println("Parent = " + service.findOne(parentEntity.getId()));
        System.out.println("Parent - child = " + service.findOne(parentEntity.getId()).getChild());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public final void whenChildIsDeletedWhileParentStillHasForeignKeyToIt_thenDataException() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        childService.delete(childEntity);
    }

    @Test
    public final void whenChildIsDeletedAfterTheParent_thenNoExceptions() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        service.delete(parentEntity);
        childService.delete(childEntity);
    }

}
