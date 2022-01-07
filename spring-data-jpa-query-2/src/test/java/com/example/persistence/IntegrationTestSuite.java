package com.example.persistence;

import com.example.persistence.audit.AuditTestSuite;
import com.example.persistence.hibernate.FooPaginationPersistenceIntegrationTest;
import com.example.persistence.hibernate.FooSortingPersistenceIntegrationTest;
import com.example.persistence.service.FooServiceBasicPersistenceIntegrationTest;
import com.example.persistence.service.FooServicePersistenceIntegrationTest;
import com.example.persistence.service.ParentServicePersistenceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ // @formatter:off
    AuditTestSuite.class
    , FooServiceBasicPersistenceIntegrationTest.class
    , FooPaginationPersistenceIntegrationTest.class
    , FooServicePersistenceIntegrationTest.class
    , ParentServicePersistenceIntegrationTest.class
    , FooSortingPersistenceIntegrationTest.class

}) // @formatter:on
public class IntegrationTestSuite {
    //
}
