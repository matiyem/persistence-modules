package jpa.data.MappedSuperclassAnnotation;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 1:10 PM
 */
@Entity(name = "DebitAccount")
public class DebitAccount extends Account {
    private BigDecimal overdraftFee;
}
