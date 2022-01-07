package jpa.data.SequenceGeneratorAnnotation;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 8:26 PM
 */
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            //ورودی initialValue برای مشخص کردن مقدار شروع میباشد
            //ورودی catalog برای مشخص کردن catalog که برای squence است
            //ورودی schema برای مشخص کردن schema ی squense است
            name = "sequence-generator",//اسم generator را مشخص میکند
            sequenceName = "product_sequence",//اسم دیتابیسی آن را دریافت میکند
            allocationSize = 5//مقداری عددی افزایش هر بار تولید
    )
    private Long id;

    @Column(name = "product_name")
    private String name;
}
