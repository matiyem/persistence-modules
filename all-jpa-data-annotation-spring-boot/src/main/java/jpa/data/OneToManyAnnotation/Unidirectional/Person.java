package jpa.data.OneToManyAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 2:56 PM
 */
@Entity(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    //این یک ارتباط یک سویه است

    //قابلیت orphanRemoval فقط برای OneToMany و OneToOne استفاده میشود این قابلیت به شرح زیر است
    //وقتی یکی از child ها remove شود به عبارتی parent به عنوان یک یتیم شناخته میشود وقتی orphanRemoval برابر با true باشد این parent های یتیم قابل شناسایی و ریمو کردن هستند زیرا بدون child ارزشی ندارد
    // مقدار orphanRemoval بصورت دیفالت برابر با false است
    //یعنی به ازای هر یک parent چندین child وجود دارد
    //وروردی cascade برای مشخص کردن نوع عملیات است
    //ورودی fetch برای مشخص کردن این است که دیتا مورد نظر باید بصورت lazy لود شود یا بصورت eager لود شود بصورت دیفالت بر روی lazy ست شده است
    //ورودی mapped by برای مشخص کردن  فیلد مالک این رابطه است
    //ورودی targetEntity برای مشخص کردن کلاس هدف این رابطه است
    //ورودی orphanRemoval برای تعیین کردن این است که رکورد هایی که از رابطه شده اند را حذف کند یا خیر که بصورت دیفالت برابر با false است
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//این در پرنت قرار میگیره
    private List<Phone> phones = new ArrayList<>();

//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Person_Phone (
//            Person_id BIGINT NOT NULL ,
//            phones_id BIGINT NOT NULL
//    )
//
//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    ALTER TABLE Person_Phone
//    ADD CONSTRAINT UK_9uhc5itwc9h5gcng944pcaslf
//    UNIQUE (phones_id)
//
//    ALTER TABLE Person_Phone
//    ADD CONSTRAINT FKr38us2n8g5p9rj0b494sd3391
//    FOREIGN KEY (phones_id) REFERENCES Phone
//
//    ALTER TABLE Person_Phone
//    ADD CONSTRAINT FK2ex4e4p7w1cj310kg2woisjl2
//    FOREIGN KEY (Person_id) REFERENCES Person
}
