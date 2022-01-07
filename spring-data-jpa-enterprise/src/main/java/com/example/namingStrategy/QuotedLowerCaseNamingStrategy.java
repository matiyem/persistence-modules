package com.example.namingStrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;


/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 2:45 PM
 */

//در اینجا در حال پیاده سازی یک naming convention هستینم که برای این کاز از کلاس SpringPhysicalNamingStrategy ارث بری کرده و متد getIdentifier را override میکنیم
public class QuotedLowerCaseNamingStrategy extends SpringPhysicalNamingStrategy {
//On the other hand, for an RDMS that is case-insensitive, both queries would have worked.
    //برای اینکه rdms را مجبور کنیم که match identifiers را رعایت کند استفاده از  quoted identifiers  است
    //با استفاده از نقل قول ها در اطراف شناسه های خود ، به پایگاه داده می گوییم که هنگام مقایسه این identifire ها با نام جدول و ستون نیز باید با مورد مطابقت داشته باشد. بنابراین ، با استفاده از مثال ما ، پرس و جو زیر کار می کند:

    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        //Let's say that we want to use quoted identifiers so that the RDMS is forced to match the case. Then we would have to use true as the quoted argument of the Identifier() constructor:
        return new Identifier(name.toLowerCase(),true);
    }
}
