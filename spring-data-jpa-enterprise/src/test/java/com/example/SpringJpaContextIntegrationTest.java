package com.example;

import com.example.boot.config.PersistenceConfiguration;
import com.example.multipledb.PersistenceProductConfiguration;
import com.example.multipledb.PersistenceUserConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {
        PersistenceConfiguration.class,
        PersistenceUserConfiguration.class,
        PersistenceProductConfiguration.class })
@ContextConfiguration(classes = ServletInitializer.class)
public class SpringJpaContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
