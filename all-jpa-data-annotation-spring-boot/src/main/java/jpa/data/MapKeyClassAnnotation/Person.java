package jpa.data.MapKeyClassAnnotation;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * created by Atiye Mousavi
 * Date: 8/24/2021
 * Time: 3:53 PM
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    private Long id;

    @ElementCollection
    //ورودی های annotation زیر به شرح زیر است
    //ورودی catalog برای وارد کردن catalog یک جدول (Optional)
    //ورودی  foreign key برای تعیین یا کنترل کلید خارجی برای ستون های مربوط به joinColumns هنگام ایجاد جدول استفاده میشود (Optional)
    //ورودی joinColums برای ستون های کلید های خارجی جدول collection که اشاره به کلید اصلی این entity اشاره دارد (Optional)
    // ورودی name اشاره به اسم جدول collection دارد (Optional)
    //ورودی schema برای وارد کردن schema جدول است (Optional)
    //ورودی uniqueConstrain فقط در زمان ایجاد جدول set میشود (Optional)

    @CollectionTable(name ="call_register",
    joinColumns = @JoinColumn(name="person_id"))
    //ورودی columnDefinitionیک قطعه sql که هنگام تولید ddl برای ستون استفاده میشود  (optional)
    //ورودی insertable برای این که ستون شامل دستورات sql insert ایجاد شده توسط persistence provider است (optional)
    //ورودی length برای ستون است (optional)
    //ورودی name اسم ستون مپ را مشخص میکند (optional)
    //ورودی nullable مشخص میکند که فیلد میتواند خالی باشد یا خیر (optional)
    //ورودی precision دقت ستون اعشاری را مشخص میکند
    //ورودی scale مقیاس ستون اعشاری را تعیین میکند
    //ورودی table نام جدولی که شامل این ستون است را مشخص میکند
    //ورودی unique مشخص میکند که آیا این ستون unique است
    //ورودی updateable مشخص میکند که این ستون در دستورات sql update تولید شده توسط persistence provider گنجانده شده است

    @MapKeyColumn(name = "call_timestamp-epoch")
    @MapKeyClass(MobilePhone.class)
    //ورودی columnDefinitionیک قطعه sql که هنگام تولید ddl برای ستون استفاده میشود  (optional)
    //ورودی insertable برای این که ستون شامل دستورات sql insert ایجاد شده توسط persistence provider است (optional)
    //ورودی length برای ستون است (optional)
    //ورودی name اسم ستون مپ را مشخص میکند (optional)
    //ورودی nullable مشخص میکند که فیلد میتواند خالی باشد یا خیر (optional)
    //ورودی precision دقت ستون اعشاری را مشخص میکند (optional)
    //ورودی scale مقیاس ستون اعشاری را تعیین میکند(optional)
    //ورودی table نام جدولی که شامل این ستون است را مشخص میکند(optional)
    //ورودی unique مشخص میکند که آیا این ستون unique است(optional)
    //ورودی updateable مشخص میکند که این ستون در دستورات sql update تولید شده توسط persistence provider گنجانده شده است(optional)

    @Column(name = "call_register")
    private Map<PhoneNumber,Integer> callRegister=new HashMap<>();


//    create table person (
//            id bigint not null,
//            primary key (id)
//)
//
//    create table call_register (
//            person_id bigint not null,
//            call_register integer,
//            country_code varchar(255) not null,
//    operator_code varchar(255) not null,
//    subscriber_code varchar(255) not null,
//    primary key (person_id, country_code, operator_code, subscriber_code)
//)
//
//    alter table call_register
//    add constraint FKqyj2at6ik010jqckeaw23jtv2
//    foreign key (person_id)
//    references person
}
