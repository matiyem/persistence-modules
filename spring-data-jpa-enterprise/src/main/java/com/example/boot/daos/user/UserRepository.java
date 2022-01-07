package com.example.boot.daos.user;

import com.example.boot.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 7:08 PM
 */
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    //وقتی خروجی لیست است و ابجکت بصورت eager است یعنی همه لیست در حافظه رم قرار میگیرد برای جلوگیری از این کار بهتر است از page استفاده کنیم گاهی تعداد
    //رکورد ها زیاد میباشد استفاده از page کافی نمیباشد بدلیل تعداد بالای درخواست ها برای بازیابی اطلاعات در این شرایط  باید از stream استفاده کنیم
    //لازم به ذکر است که بعد از اتمام کار باید stream را ببندیم
    Stream<User> findAllByName(String name);

    @Query("SELECT u FROM User u WHERE u.status = 1")
    Collection<User> findAllActiveUsers();

    @Query("select u from User u where u.email like '%@gmail.com'")
    List<User> findUsersWithGmailAddress();

    @Query(value = "SELECT * FROM Users u WHERE u.status = 1", nativeQuery = true)
    Collection<User> findAllActiveUsersNative();

    @Query("SELECT u FROM User u WHERE u.status = ?1")
    User findUserByStatus(Integer status);

    @Query(value = "SELECT * FROM Users u WHERE u.status = ?1", nativeQuery = true)
    User findUserByStatusNative(Integer status);

    @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
    User findUserByStatusAndName(Integer status, String name);

    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name);

    @Query(value = "SELECT * FROM Users u WHERE u.status = :status AND u.name = :name", nativeQuery = true)
    User findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    User findUserByUserStatusAndUserName(@Param("status") Integer userStatus, @Param("name") String userName);

    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    User findUserByNameLike(String name);

    @Query("SELECT u FROM User u WHERE u.name like :name%")
    User findUserByNameLikeNamedParam(@Param("name") String name);

    @Query(value = "SELECT * FROM users u WHERE u.name LIKE ?1%", nativeQuery = true)
    User findUserByNameLikeNative(String name);

    @Query(value = "SELECT u FROM User u")
    List<User> findAllUsers(Sort sort);

    //وقتی خروجی لیست است و ابجکت بصورت eager است یعنی همه لیست در حافظه رم قرار میگیرد برای جلوگیری از این کار بهتر است از page استفاده کنیم
    @Query(value = "SELECT u FROM User u ORDER BY id")
    Page<User> findAllUsersWithPagination(Pageable pageable);

    @Query(value = "SELECT * FROM Users ORDER BY id", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
    Page<User> findAllUsersWithPaginationNative(Pageable pageable);

    @Modifying
    @Query("update User u set u.status = :status where u.name = :name")
    int updateUserSetStatusForName(@Param("status") Integer status, @Param("name") String name);

    @Modifying
    @Query(value = "UPDATE Users u SET u.status = ? WHERE u.name = ?", nativeQuery = true)
    int updateUserSetStatusForNameNative(Integer status, String name);

    @Query(value = "INSERT INTO Users (name, age, email, status, active) VALUES (:name, :age, :email, :status, :active)", nativeQuery = true)
    @Modifying
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("email") String email, @Param("status") Integer status, @Param("active") boolean active);

    @Modifying
    @Query(value = "UPDATE Users u SET status = ? WHERE u.name = ?", nativeQuery = true)
    int updateUserSetStatusForNameNativePostgres(Integer status, String name);

    @Query(value = "SELECT u FROM User u WHERE u.name IN :names")
    List<User> findUserByNameList(@Param("names") Collection<String> names);

    void deleteAllByCreationDateAfter(LocalDate date);

    //اگر پرسش تعدیل کننده ما موجودات موجود در زمینه ماندگاری را تغییر دهد ، این زمینه قدیمی می شود. یکی از راه های مدیریت این وضعیت ، پاک سازی زمینه پایداری است. با انجام این کار ، ما مطمئن می شویم که زpersistence context دفعه بعد نهادها را از پایگاه داده خارج می کند.
    //با این حال ، لازم نیست که روشclear  را در EntityManager فراخوانی کنیم. ما فقط می توانیم از ویژگی clearAutomatically از حاشیه نویسیModifying استفاده کنیم:
    //به این ترتیب ، ما مطمئن می شویم که persistence context پس از اجرای درخواست ما پاک می شود.
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u set u.active = false where u.lastLoginDate < :date")
    void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("delete User u where u.active = false")
    int deleteDeactivatedUsers();

    @Query("delete User u where u.active = false")
    int deleteDeactivatedUsersWithNoModifyingAnnotation();

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "alter table USERS add column deleted int(1) not null default 0", nativeQuery = true)
    void addDeletedColumn();
}
