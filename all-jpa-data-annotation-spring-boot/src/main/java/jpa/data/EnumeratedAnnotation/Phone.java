package jpa.data.EnumeratedAnnotation;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Phone")
@Data
public class Phone {
    @Id
    private Long id;

    @Column(name = "phone_number")
    private String number;

    //برای تعیین تایپ mapping مورد استفاده
    @Enumerated(EnumType.ORDINAL)//در این حالت با توجه به جایگاری که دارند مقدار برای آن در نظر گرفته میشود
    //مقدار string آن در نظر گرفته میشود
//    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType type;

}
