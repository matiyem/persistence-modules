package jpa.data.MapKeyJoinColumnAnnotation;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * created by Atiye Mousavi
 * Date: 8/25/2021
 * Time: 4:04 PM
 */

@Entity
@Data
public class VideoStore {

    @Id
    private int id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "INVENTORY",
    joinColumns = @JoinColumn(name = "STORE"))
    @Column(name = "COPES_IN_STOCK")
    //ورودی columnDefinition برای قطعه کد sql است که برای تولید ddl برای ستون استفاده میشود
    //ورودی foreignKeyبرای مشخص کردن کلید خارجی است
    //ورودی insertable برای این که ستون شامل دستورات sql insert ایجاد شده توسط persistence provider است
    //ورودی name برای مشخص کردن اسم کلید خارجی است
    //ورودی nullable برای مشخص کردن این است که فیلد میتواند خالی باشد یا خیر
    //ورودی referencedColumnName برای مشخص کردن فیلد مورد اشاره در قسمت name است
    //ورودی table برای مشخص کردن table که شامل کلید خارجی است
    //ورودی unique برای مشخص کردن  unique بودن و نبودن است
    //ورودی updateable مشخص میکند که این ستون در دستورات sql update تولید شده توسط persistence provider گنجانده شده است
    @MapKeyJoinColumn(name = "MOVIE",referencedColumnName = "ID")
    private Map<Movie,Integer> videoInventory;
}
