package jpa.data.OneToOneAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 3:59 PM
 */
@Entity(name = "phone")
@Data
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    //یک ارتباط یک سویه است
    //وروردی cascade برای مشخص کردن نوع عملیات است
    //ورودی fetch برای مشخص کردن این است که دیتا مورد نظر باید بصورت lazy لود شود یا بصورت eager لود شود بصورت دیفالت بر روی lazy ست شده است
    //ورودی mapped by در ارتباطات دو سویه استفاده میشود و توسط parent ست میشود
    //ورودی optional به معنی این است که این وابستگی اختیاری است یا خیر
    //قابلیت orphanRemoval فقط برای OneToMany و OneToOne استفاده میشود این قابلیت به شرح زیر است
    //وقتی یکی از child ها remove شود به عبارتی parent به عنوان یک یتیم شناخته میشود وقتی orphanRemoval برابر با true باشد این parent های یتیم قابل شناسایی و ریمو کردن هستند زیرا بدون child ارزشی ندارد
    // مقدار orphanRemoval بصورت دیفالت برابر با false است
    //ورودی targetEntity برای مشخص کردن کلاس هدف این رابطه است

    @OneToOne
    @JoinColumn(name = "details_id")//یک کلید خارجی است.مطابق فیلد دیتابیس است
    private PhoneDetails details;

    public Phone() {
    }

//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    details_id BIGINT ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE PhoneDetails (
//            id BIGINT NOT NULL ,
//            provider VARCHAR(255) ,
//    technology VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    ALTER TABLE Phone
//    ADD CONSTRAINT FKnoj7cj83ppfqbnvqqa5kolub7
//    FOREIGN KEY (details_id) REFERENCES PhoneDetails
}
