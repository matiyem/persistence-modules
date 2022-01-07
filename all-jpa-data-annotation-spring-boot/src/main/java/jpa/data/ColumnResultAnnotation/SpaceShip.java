package jpa.data.ColumnResultAnnotation;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@NamedNativeQueries({
        //ورودی name برای ست کردن یک اسم دلخواه برای اینکه بتوانیم این query توسط entityManger اجرا شود
        //ورودی query برای نوشتن query مورد نظر است
        //ورودی Hint برای نکات و پراپرتی ها میباشد
        //ورودی resultClass برای تعیین کردن کلاس برای result است
        //ورودی resultSetMapping نام SqlResultSetMapping را میگیرد
        @NamedNativeQuery(name = "find_all_spaceships",query =  "SELECT " +
                "   name as \"name\", " +
                "   model, " +
                "   speed, " +
                "   lname as lastn, " +
                "   fname as firstn, " +
                "   length, " +
                "   width, " +
                "   length * width as surface, " +
                "   length * width * 10 as volume " +
                "FROM SpaceShip",
        resultSetMapping = "spaceship")
})
//میتونیم از @ConstructorResult استفاده کنیم انگار از طریق constructor ساخته میشه.مثل کد زیر
//List<PersonPhoneCount> personNames = session.getNamedNativeQuery(
//	"get_person_phone_count")
//.getResultList();


//ورودی name اسمی که در قسمت resultSetMapping تعریف شده است را میگیرد
//ورودی classes برای مشخص کردن این است که CONSTRUCTOR نتیجه را مشحص میکند
//ورودی column برای تعیین نتیجه به ستون مورد نظر است
//ورودی entity برای ست کردن entity مورد نظر است
@SqlResultSetMapping(name="spaceship",
        //ورودی discriminatorColumn برای مشخص تعیین نوع entity در select
        //ورودی fields برای مپ کردن فیلد ها استفاده میشود
        entities = @EntityResult( entityClass = SpaceShip.class,

fields = {
        @FieldResult(name = "name",column = "name"),//این فیلد صراحتا در کوییری تعریف شده اند
        @FieldResult(name = "model", column = "model"),
        @FieldResult(name = "speed", column = "speed"),
        @FieldResult(name = "captain.lastname", column = "lastn"),
        @FieldResult(name = "captain.firstname", column = "firstn"),
        @FieldResult(name = "dimensions.length", column = "length"),
        @FieldResult(name = "dimensions.width", column = "width"),
}),
        columns = {
        @ColumnResult(name = "suface"),//این دو تا فیلد طی یک عملیات نتایج ان ها بوجود میاد برای همین به این صورت تعریف شده
        @ColumnResult(name = "volume"),
        }
)
@Data
public class SpaceShip {
        @Id
        private String name;

        private String model;

        private double speed;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumns({
                @JoinColumn(name = "fname", referencedColumnName = "firstname"),
                @JoinColumn(name = "lname", referencedColumnName = "lastname")
        })
        private Captain captain;

        private Dimensions dimensions;
}
