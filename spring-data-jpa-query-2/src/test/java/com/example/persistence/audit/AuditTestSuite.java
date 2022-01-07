package com.example.persistence.audit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 7:49 PM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ // @formatter:off
        EnversFooBarAuditIntegrationTest.class,
        JPABarAuditIntegrationTest.class,
        SpringDataJPABarAuditIntegrationTest.class
}) // @formatter:on
public class AuditTestSuite {
}
