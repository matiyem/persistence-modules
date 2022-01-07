package jpa.data.ManyToManyAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 11:08 AM
 */

@Entity(name = "Address")
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    @Column(name = "number")
    private String number;


//    CREATE TABLE Address (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    street VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Person_Address (
//            Person_id BIGINT NOT NULL ,
//            addresses_id BIGINT NOT NULL
//    )
//
//    ALTER TABLE Person_Address
//    ADD CONSTRAINT FKm7j0bnabh2yr0pe99il1d066u
//    FOREIGN KEY (addresses_id) REFERENCES Address
//
//    ALTER TABLE Person_Address
//    ADD CONSTRAINT FKba7rc9qe2vh44u93u0p2auwti
//    FOREIGN KEY (Person_id) REFERENCES Person

}
