package jpa.data.SecondaryTableAnnotation;

import lombok.Data;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 7:48 PM
 */
@Entity(name = "Person")
//ورودی name برای مشخص اسم جدول است
//ورودی catalog برای مشخص کردن catalog جدول است
//ورودی schema برای مشخص schema جدول است
//ورودی index برای مشخص کردن Index جدول است
//ورودیuniqueConstraints برای مشخص کردن uniqueConstraints است

@Table(name = "person")
//
@SQLInsert(
        sql = "INSERT INTO person (name, id, valid) VALUES (?, ?, true) "
)
@SQLDelete(
        sql = "UPDATE person SET valid = false WHERE id = ? "
)
//ورودی name برای مشخص اسم جدول است
//ورودی catalog برای مشخص کردن catalog جدول است
//ورودی schema برای مشخص schema جدول است
//ورودی index برای مشخص کردن Index جدول است
//ورودیpkJoinColumns برای مشخص کردن فیلدهایی که قرار است join شوند
//ورودیuniqueConstraints برای مشخص کردن uniqueConstraints است
@SecondaryTable(name = "person_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id"))

//از این annotation برای seceondary table ها استفاده میشود
@org.hibernate.annotations.Table(
        appliesTo = "person_details",//اسم تیبل secendary
        sqlInsert = @SQLInsert(
                sql = "INSERT INTO person_details (image, person_id, valid) VALUES (?, ?, true) ",
                check = ResultCheckStyle.COUNT
        ),
        sqlDelete = @SQLDelete(
                sql = "UPDATE person_details SET valid = false WHERE person_id = ? "
        )
)
@Loader(namedQuery = "find_valid_person")//برای لود کردن دیتا است که در ایجا از nameQury استفاده شده است
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "find_valid_person",
                query = "SELECT " +
                        "    p.id, " +
                        "    p.name, " +
                        "    pd.image  " +
                        "FROM person p  " +
                        "LEFT OUTER JOIN person_details pd ON p.id = pd.person_id  " +
                        "WHERE p.id = ? AND p.valid = true AND pd.valid = true",
                resultClass = Person.class
        )
})
@Data
public class Person {
        @Id
        @GeneratedValue
        private Long id;

        private String name;

        @Column(name = "image", table = "person_details")
        private byte[] image;
}
