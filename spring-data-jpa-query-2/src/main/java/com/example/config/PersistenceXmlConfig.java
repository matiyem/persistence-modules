package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 6:41 PM
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.example.persistence.dao","com.example.persistence.service"})
@ImportResource({ "classpath:hibernate4Config.xml" })

public class PersistenceXmlConfig {
    public PersistenceXmlConfig() {
        super();
    }
}
