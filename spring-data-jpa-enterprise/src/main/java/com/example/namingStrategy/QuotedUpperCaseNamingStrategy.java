package com.example.namingStrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 2:47 PM
 */

public class QuotedUpperCaseNamingStrategy extends SpringPhysicalNamingStrategy {
    //این یک custom naming strategy using Spring Data است
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        return new Identifier(name.toUpperCase(),true);
    }
}
