package jpa.data.AssociationOverrideAnnotation;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "Book")
@AttributeOverrides({
        @AttributeOverride(
                name = "ebookPublisher.name",//مطابق با فیلد در سطح entity هست
                column = @Column(name = "ebook_publisher_name")//مطابق نام فیلد دیتابیسی آن است
        ),
        @AttributeOverride(
                name = "paperBackPublisher.name",
                column = @Column(name = "paper_back_publisher_name")
        )
})
@AssociationOverrides({//برای مپ کردن relation بین entity ها استفاده میشود
        @AssociationOverride(
                //ورودی foreignKey برای تعیین کلید خارجی است
                //ورودی joinTable برای مپ کردن table است
                name = "ebookPublisher.country",//اسم این فیلد مورد نظر در سطح entity
                joinColumns = @JoinColumn(name = "ebook_publisher_country_id")//برای مپ کردن فیلدی که در قسمت name آورده شده است
        ),
        @AssociationOverride(
                name = "paperBackPublisher.country",
                joinColumns = @JoinColumn(name = "paper_back_publisher_country_id")
        )
})
@Data
public class Book {
    //وقتی ما یک entity داریم که در entity های مختلف برای کاهای متفاوت inject میشود باید از @AssociationOverrides و @AttributeOverrides استفاده کینم
    //اگر بخواهیم از publisher دیفالت استفاده کنیم دچار confilict میشویم
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private Publisher ebookPublisher;

    private Publisher paperBackPublisher;




//    create table Book (
//            id bigint not null,
//            author varchar(255),
//    ebook_publisher_name varchar(255),
//    paper_back_publisher_name varchar(255),
//    title varchar(255),
//    ebook_publisher_country_id bigint,
//    paper_back_publisher_country_id bigint,
//    primary key (id)
//)
//
//    alter table Book
//    add constraint FKm39ibh5jstybnslaoojkbac2g
//    foreign key (ebook_publisher_country_id)
//    references Country
//
//    alter table Book
//    add constraint FK7kqy9da323p7jw7wvqgs6aek7
//    foreign key (paper_back_publisher_country_id)
//    references Country

}
