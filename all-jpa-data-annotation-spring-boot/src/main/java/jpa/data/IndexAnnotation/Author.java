package jpa.data.IndexAnnotation;

import javax.persistence.*;

@Entity
//ورودی name برای مشخص کردن اسم جدول مورد استفاده قرار میگردد
//ورودی catalog برای مشخص کردن catalog جدول است
//ورودی sechma  برای مشخص کردن sechma جدول است
//ورودی uniqueConstraints برای مشخص کردن uniqueConstraints جدول است
//ورودی index برای مشخص کردن index جدول است
@Table(name = "author",
indexes = @Index(
        name = "idx_author_first_last_name",//در این جا اسم index را مشخص میکند
        columnList = "first_name, last_name",//اینجاد مشخص کرده که این دو فیلد دیتابیسی index هستند
        unique = false//در اینجا unique بودن یا نبودن را مشخص میکند
))
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    create table author (
//            id bigint not null,
//            first_name varchar(255),
//    last_name varchar(255),
//    primary key (id)
//)
//
//    create index idx_author_first_last_name
//    on author (first_name, last_name)

}
