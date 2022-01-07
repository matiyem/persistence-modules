package jpa.data.MappedSuperclassAnnotation;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 1:08 PM
 */
@MappedSuperclass
@Data
public class Account {

//    هنگام استفاده از MappedSuperclass ، وراثت فقط در مدل دامنه قابل مشاهده است و هر جدول پایگاه داده شامل کلاس پایه و ویژگی های زیر کلاس است.
    @Id
    private Long id;

    private String owner;

    private BigDecimal balance;

    private BigDecimal interestRate;
}
