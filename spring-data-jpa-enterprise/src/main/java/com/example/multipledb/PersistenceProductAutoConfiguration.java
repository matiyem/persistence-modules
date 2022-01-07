package com.example.multipledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 10:29 AM
 */
@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
@EnableJpaRepositories(basePackages = "com.example.multipledb.dao.product",entityManagerFactoryRef = "productEntityManager", transactionManagerRef = "productTransactionManager")
@Profile("!tc")
public class PersistenceProductAutoConfiguration {
    //برای کاانفیگ کردن url های دیتابیسی است

    @Autowired
    private Environment env;

    public PersistenceProductAutoConfiguration() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManager(){
        final LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(productDataSource());
        em.setPackagesToScan("com.example.multipledb.dao.product");

        final HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String,Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }
    @Bean
    //پراپرتی هایی که با این مقدار شروع میشود را میگیرد
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource productDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public PlatformTransactionManager productTransactionManager(){
        final JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(productEntityManager().getObject());
        return transactionManager;

    }
}
