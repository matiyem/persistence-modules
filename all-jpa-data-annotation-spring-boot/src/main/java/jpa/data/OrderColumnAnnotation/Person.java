package jpa.data.OrderColumnAnnotation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 4:43 PM
 */
@Entity(name = "person")
public class Person {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    //ورودی columnDefinition برای قطعه کد sql است که برای تولید ddl برای ستون استفاده میشود
    //ورودی insertable برای این که ستون شامل دستورات sql insert ایجاد شده توسط persistence provider است
    //ورودی name برای مشخص کردن نام فیلد دیتابیسی است
    //ورودی nullable برای مشخص کردن این است که فیلد میتواند خالی باشد یا خیر
    //ورودی updateable مشخص میکند که این ستون در دستورات sql update تولید شده توسط persistence provider گنجانده شده است
    @OrderColumn(name = "order_id")//اسم دیتابیسی فیلد را مینویسیم
    private List<Phone> phones = new ArrayList<>();


//    CREATE TABLE Person_Phone (
//            Person_id BIGINT NOT NULL ,
//            phones_id BIGINT NOT NULL ,
//            order_id INTEGER NOT NULL ,
//            PRIMARY KEY ( Person_id, order_id )
//)

}
