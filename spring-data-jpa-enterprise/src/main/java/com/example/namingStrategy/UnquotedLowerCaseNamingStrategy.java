package com.example.namingStrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class UnquotedLowerCaseNamingStrategy extends SpringPhysicalNamingStrategy {
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        //اگر بخواهیم quotetion اجباری نباشد مقدار quoted را برابر با false قرار میدهیم
        return new Identifier(name.toLowerCase(), false);
    }
}
