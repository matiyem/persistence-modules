package com.example.osiv.repository;

import com.example.osiv.model.BasicUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:07 PM
 */
@Repository
@Transactional
public interface BasicUserRepository extends JpaRepository<BasicUser,Long> {
    //هنگام تعریف روشهای پرس و جو در JPA Spring Data ، می توانیم یک روش پرس و جو باEntityGraph برای واکشی eager بخشی از موجودیت یادداشت کنیم:
    @EntityGraph(attributePaths = "permissions")
    //وقتی خروجی optional در نظر گرفته میشود یعنی ممکن خروجی وجود نداشته باشد
    //When returning an Optional instance, it's a useful hint that there's a possibility that the value might not exist
    Optional<BasicUser> findDetailedByUsername(String userName);
}
