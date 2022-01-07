package jpa.data.MappedSuperclassAnnotation;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 1:11 PM
 */
@Entity(name = "CreditAccount ")
@Data
public class CreditAccount extends Account{
    private BigDecimal creditLimit;

//    CREATE TABLE DebitAccount (
//            id BIGINT NOT NULL ,
//            balance NUMERIC(19, 2) ,
//    interestRate NUMERIC(19, 2) ,
//    owner VARCHAR(255) ,
//    overdraftFee NUMERIC(19, 2) ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE CreditAccount (
//            id BIGINT NOT NULL ,
//            balance NUMERIC(19, 2) ,
//    interestRate NUMERIC(19, 2) ,
//    owner VARCHAR(255) ,
//    creditLimit NUMERIC(19, 2) ,
//    PRIMARY KEY ( id )

}
