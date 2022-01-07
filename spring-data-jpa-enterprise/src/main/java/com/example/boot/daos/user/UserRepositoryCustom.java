package com.example.boot.daos.user;

import com.example.boot.domain.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 7:08 PM
 */
public interface UserRepositoryCustom {
    //وقتی خروجی لیست است و ابجکت بصورت eager است یعنی همه لیست در حافظه رم قرار میگیرد برای جلوگیری از این کار بهتر است از page استفاده کنیم
    List<User> findUserByEmails(Set<String> emails);

    List<User> findAllUsersByPredicates(Collection<Predicate<User>> predicates);
}
