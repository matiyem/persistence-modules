package jpa.data.ForeignKeyAnnotation;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Phone")
@Data
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    //ورودی Cascade برای تعیین نوع عملیات استفاده میشود
    //ورودی feche برای تعیین کردن این است که دیتا بصورت lazy لود شود یا بصورت eager
    //ورودی targetEntity که کلاس هدف را مشخص میکند
    //ورودی optional به معنی این است که این وابستگی اختیاری است یا خیر
    @ManyToOne()
    //ورودی columnDefinition برای قطعه کد sql است که برای تولید ddl برای ستون استفاده میشود
    //ورودی foreignKey برای تعیید کلید خارجی است
    //ورودی insertable برای این که ستون شامل دستورات sql insert ایجاد شده توسط persistence provider است
    //ورودی name برای تعیین نام کلید خارجی اسنفاده میشود که مطابق با فیلد دیتابیس است
    //ورودی nullable برای کلید خارجی است که تعییر میکند کلید خارجی میتواند خالی باشد یا خیر
    //ورودی referencedColumnName برای این است که مشخص کنیم به چه ستونی دارد اشاره میکند.
    //ورودی tableبرای تعیین اسم جدولی که این ستون شامل آن است
    //ورودی unique برای این است که تعییر کنیم آیا این فیلد یونیک است یا خیر
    //ورودی updateable مشخص میکند که این ستون در دستورات sql update تولید شده توسط persistence provider گنجانده شده است
    @JoinColumn(name = "person_id",//اسم این مطابق فیلد دیتابیس است
            foreignKey = @ForeignKey(name = "Person_Id_fk"))
    private Person person;





}
