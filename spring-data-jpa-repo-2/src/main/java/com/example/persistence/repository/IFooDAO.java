package com.example.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * created by Atiye Mousavi
 * Date: 9/4/2021
 * Time: 10:32 AM
 */
public interface IFooDAO extends JpaRepository<Foo,Long> {//این کلاس برای فعال سازی jpa است با ارث بری از این اینترفیس یک سری از متد ها جنریت میشود اگر نیاز به متد های دیگر است از اینترفیس دیگری ارث بری کنیم یا از کوییری نوشتن استفاده کنیم
    //در صورتی که parserنتواند ویژگی را مطابقت دهد با خطای زیر موجه میشویم
    //java.lang.IllegalArgumentException: No property nam found for type class com.baeldung.spring.data.persistence.model.Foo
    Foo findByName(String name);

    @Query("select f from Foo f where lower(f.name) = lower(:name) ")
    Foo retrieveByName(@Param("name")String name);

}
