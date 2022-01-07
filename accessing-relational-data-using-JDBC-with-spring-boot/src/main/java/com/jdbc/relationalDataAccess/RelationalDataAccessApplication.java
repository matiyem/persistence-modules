package com.jdbc.relationalDataAccess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class RelationalDataAccessApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //بعد از لود شدنapplication contex این متد اجرا میشود
        log.info("Creating Table");
        jdbcTemplate.execute("DROP Table customers if EXISTS ");
        jdbcTemplate.execute("CREATE table customers(id SERial ,first_name VARCHAR (255)," +
                "last_name varchar(255) )");
        List<Object[]> splitUpNames= Arrays.asList("John Woo","Jeff Dean","Josh Bloch","Josh Long").stream().map(name ->name.split(" ")).collect(Collectors.toList());
        splitUpNames.forEach(name -> log.info("inserting customer record for %s %s",name[0],name[1]));

        jdbcTemplate.batchUpdate("INSERT  into customers(first_name,last_name) values (?,?)",splitUpNames);

        log.info("Querying for customer records where first_name='Josh':");

        jdbcTemplate.query("select id,first_name,last_name from customers where first_name=?",new Object[]{"Josh"},
                (rs,rowNum)-> new Customer(rs.getLong("id"),
                        rs.getString("first_name"),rs.getString("last_name"))).forEach(customer -> log.info(customer.toString()));

    }
}
