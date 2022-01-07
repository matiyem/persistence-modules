package com.example.spring.data.jpa.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 10:08 AM
 */

public interface UserRepository extends JpaRepository<User,Integer> ,UserRepositoryCustom {

    @Query("select u from User u where u.status=1")
    Collection<User> findAllActiveUsers();

    //ما همچنین می توانیم از native sql برای تعریف query خود استفاده کنیم. تنها کاری که ما باید انجام دهیم این است که مقدار ویژگی nativeQuery را روی true تنظیم کنیم و پرس و جو SQL اصلی را در ویژگی مقدار حاشیه نویسی تعریف کنیم:
    @Query(value = "select * from Users u where u.status=1", nativeQuery = true)
    Collection<User> findAllActiveUsersNative();

    //وقتی Spring Data دستور مرتب سازی ناامن را برای روشی که از حاشیه نویسیQuery استفاده می کند ، کشف کند ، فقط بند مرتب سازی را به پرس و جو اضافه می کند - از بررسی اینکه آیا ویژگی مرتب سازی بر اساس مدل دامنه تعلق دارد یا خیر چشم پوشی میشود
    //userRepository.findAllUsers(JpaSort.unsafe("LENGTH(name)"));
    //When the @Query annotation uses native SQL, then it's not possible to define a Sort.
    //org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException: Cannot use native queries with dynamic sorting and/or pagination
    @Query(value = "select u from User u")
    List<User> findAllUsers(Sort sort);
    //صفحه بندی همچنین برایnative query پشتیبانی می شود ، اما نیاز به کمی کار اضافی دارد.
    @Query(value = "select u from User u order by id")
    Page<User> findAllUsersWithPagination(Pageable pageable);

    //We can enable pagination for native queries by declaring an additional attribute countQuery.
     //این راه حل  برای پرس و جوهای اصلی برای نسخه های JPG Spring Data 2.0.4 و بالاتر مناسب است.
    @Query(value = "select * from Users order by id",countQuery = "SELECT count (*) from Users",nativeQuery = true)
    Page<User> findAllUsersWithPaginationNative(Pageable pageable);
    //There are two possible ways that we can pass method parameters to our query: indexed and named parameters.
    @Query("select u from User u where u.status=?1")
    User findUserByStatus(Integer status);

    @Query("SELECT u from User  u where u.status = ?1 and u.name=?2")
    User findUserByStatusAndName(Integer status, String name);


    //There are two possible ways that we can pass method parameters to our query: indexed and named parameters.
    //برای native query ها هم دقیقا به همین صورت است
    @Query(value = "SELECT * FROM Users u WHERE u.status = ?1", nativeQuery = true)
    User findUserByStatusNative(Integer status);

    //ارسال پارامتر بر اساس name paramater است
    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    User findUserByUserStatusAndUserName(@Param("status") Integer userStatus, @Param("name") String userName);

    @Query(value = "SELECT * FROM Users u WHERE u.status = :status AND u.name = :name", nativeQuery = true)
    User findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);

    //در اینجا ورودی name یک collection است
    @Query(value = "SELECT u FROM User u WHERE u.name IN :names")
    List<User> findUserByNameList(@Param("names") Collection<String> names);

    //برای آپدیت دیتابیس باید از Modifuyng@ استفاده کنیم و همچنین در قسمت query باید عبارت مناست را داشته باشیم و از این روش میتوان برای native query ها هم استفاده کرد
    @Modifying
    @Query("update User u set u.status = :status where u.name = :name")
    int updateUserSetStatusForName(@Param("status") Integer status, @Param("name") String name);

    @Modifying
    @Query(value = "UPDATE Users u SET u.status = ? WHERE u.name = ?", nativeQuery = true)
    int updateUserSetStatusForNameNative(Integer status, String name);

    //برای کوییری insert حتما باید تز native query استفاده کنیم زیرا insert قسمتی از jpa interface نمیباشد
    @Query(value = "INSERT INTO Users (name, age, email, status, active) VALUES (:name, :age, :email, :status, :active)", nativeQuery = true)
    @Modifying
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("email") String email, @Param("status") Integer status, @Param("active") boolean active);



}

