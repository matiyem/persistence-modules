package jpa.data.DiscriminatorColumnAnnotation;

import lombok.Data;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import java.math.BigDecimal;




//@DiscriminatorColumn مثالی نبود بیشتر باید بگردم
@Entity(name = "Account")
//حالت single table برای حالتی است سک table وجود دارد و حالت join برای حالتی است که چندین table وجود دارد و به هم دیگر کلید خارجی دارند
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//فقط در این استراژدی میتوان استفاده کرد در حالت join نمیتوان از Discriminator استفاده کرد
//@DiscriminatorValue(value = "Debit")
//برای کد بالا میتوان مقدار null و یا not null
@DiscriminatorFormula("case when debitKey is not null" +//برای این است که با استفاده از یک کوییری برای شناسایی یک مورد خاص استفاده میشود
        "then 'Debit'" +
        "else ( case when CreditKey is not null" +
        "then 'Credit'" +
        "else 'Unkown'" +
        "end )" +
        "end")
@Data
public class Account {

    @Id
    private Long id;

    private String owner;
    private BigDecimal balance;
    private BigDecimal insertRate;



//    CREATE TABLE Account (
//            id int8 NOT NULL ,
//            balance NUMERIC(19, 2) ,
//    interestRate NUMERIC(19, 2) ,
//    owner VARCHAR(255) ,
//    debitKey VARCHAR(255) ,
//    overdraftFee NUMERIC(19, 2) ,
//    creditKey VARCHAR(255) ,
//    creditLimit NUMERIC(19, 2) ,
//    PRIMARY KEY ( id )
//)
}
