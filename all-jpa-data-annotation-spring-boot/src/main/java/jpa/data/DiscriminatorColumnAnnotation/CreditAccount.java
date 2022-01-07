package jpa.data.DiscriminatorColumnAnnotation;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "CreditAccount")
@DiscriminatorValue(value="Credit")//این ها در قسمت DiscriminatorFormula در کلاس account تعریف شده است و در اینجا استفاده میشود
@Data
public class CreditAccount extends Account{
    private String creditKey;
    private BigDecimal creditLimit;
}
