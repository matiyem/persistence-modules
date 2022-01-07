package jpa.data.PrimaryKeyJoinColumnAnnotation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 6:47 PM
 */
@Entity(name = "PersonDetails")
@Data
public class PersonDetails {
    @Id
    private Long id;

    private String nickName;

    @OneToOne
    //ورودی columnDefinition برای قطعه کد sql است که برای تولید ddl برای ستون استفاده میشود
    //ورودی foreignkey برای تعریف کلید خارجی است
    //ورودی name نام کلید اصلی جدول فعلی را میگیرد
    //ورودی referencedColumnName برای مشخص کردن نام کلید اصلی جدول join شده
    @PrimaryKeyJoinColumn
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        this.id = person.getId();
    }
}
