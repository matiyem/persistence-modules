package jpa.data.JoinTable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 8:33 AM
 */

@Entity(name = "Person")
public class Person {

    @Id
    private Long id;

    //قابلیت orphanRemoval فقط برای OneToMany و OneToOne استفاده میشود این قابلیت به شرح زیر است
    //وقتی یکی از child ها remove شود به عبارتی parent به عنوان یک یتیم شناخته میشود وقتی orphanRemoval برابر با true باشد این parent های یتیم قابل شناسایی و ریمو کردن هستند زیرا بدون child ارزشی ندارد
    // مقدار orphanRemoval بصورت دیفالت برابر با false است
    //یعنی به ازای هر یک parent چندین child وجود دارد
    //وروردی cascade برای مشخص کردن نوع عملیات است
    //ورودی fetch برای مشخص کردن این است که دیتا مورد نظر باید بصورت lazy لود شود یا بصورت eager لود شود بصورت دیفالت بر روی lazy ست شده است
    //ورودی mapped by برای مشخص کردن  فیلد مالک این رابطه است
    //ورودی targetEntity برای مشخص کردن کلاس هدف این رابطه است
    //ورودی orphanRemoval برای تعیین کردن این است که رکورد هایی که از رابطه شده اند را حذف کند یا خیر که بصورت دیفالت برابر با false است
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)

    //ورودی catalog برای مشخص کردن catalog جدول است
    //ورودی foreignKey برای مشخص کردن کلید خارجی جدول است
    //ورودی index برای مشخص کردن index جدول است
    //ورودی inverseJoinColumns برای تعیین کلید خارجی یک جدول که در قست name مشخص شده است
    //ورودیJoinColumn برای تعیین کلید خارجی جدول مورد استفاده قرار میگیرد
    //ورودی name برای مشخص کردن نام جدول مورد استفاده قرار میگیرد
    //ورودی schema برای مشخص کردی schema جدول مورد استفاده قرار میگیرد
    //ورودی uniqueConstraints برای مشخص uniqueConstraints جدول مورد استفاده قرار میگیرد
    @JoinTable(
            name = "phone_register",
            joinColumns=@JoinColumn(name = "phone_id"),//نام این فیلد مطابق با دیتابیس است

            //پراپرتی inverseJoinColumns در اصل یک PRIMARY KE و یک FOREIGN KEY جدولی که در قسمت name مشخص شده است این فیلد optional است
            inverseJoinColumns = @JoinColumn(name = "person_id"))//نام این فیلد مطابق با دیتابیس انتخاب شده

    @MapKey(name = "since")//فقط برای map استفاده میشود برای مشخص کردن primary key و یا attribute یک entity دیگر استفاده میشود
    @MapKeyTemporal(TemporalType.TIMESTAMP)//برای مشخص کردن نوع فیلد است که دارای سه حالت بیشتر نیست و فقط برای map استفاده میشود
    private Map<Date,Phone> phoneRegister=new HashMap<>();

    public void addPhone(Phone phone){
        phoneRegister.put(phone.getSince(),phone);
    }

//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    since TIMESTAMP ,
//    type INTEGER ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE phone_register (
//            phone_id BIGINT NOT NULL ,
//            person_id BIGINT NOT NULL ,
//            PRIMARY KEY ( phone_id, person_id )
//)
//
//    ALTER TABLE phone_register
//    ADD CONSTRAINT FKc3jajlx41lw6clbygbw8wm65w
//    FOREIGN KEY (person_id) REFERENCES Phone
//
//    ALTER TABLE phone_register
//    ADD CONSTRAINT FK6npoomh1rp660o1b55py9ndw4
//    FOREIGN KEY (phone_id) REFERENCES Person
}
