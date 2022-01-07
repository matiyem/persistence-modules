package com.example.boot.config;

import com.example.boot.services.IBarService;
import com.example.boot.services.impl.BarSpringDataJpaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 10:39 AM
 */
@Configuration
@Profile("!tc")
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {

    @Bean
    public IBarService barSpringDataJpaService() {
        return new BarSpringDataJpaService();
    }
}
