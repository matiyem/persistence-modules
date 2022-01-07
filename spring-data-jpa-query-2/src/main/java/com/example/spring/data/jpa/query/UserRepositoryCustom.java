package com.example.spring.data.jpa.query;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 10:09 AM
 */

public interface UserRepositoryCustom {


    List<User> findUserByEmails(Set<String> emails);

    List<User> findAllUsersByPredicates(Collection<Predicate<User>> predicates);}
