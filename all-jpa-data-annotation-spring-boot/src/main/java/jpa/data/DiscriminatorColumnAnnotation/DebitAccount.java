package jpa.data.DiscriminatorColumnAnnotation;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "DebitAccount")
@DiscriminatorValue(value = "Debit")
@Data
public class DebitAccount extends Account {

    private String debitkey;
    private BigDecimal overdrartFee;

}
