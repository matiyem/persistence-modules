package jpa.data.ManyToManyAnnotation.Bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String postalCode;

    @ManyToMany(mappedBy = "addresses")//اسم این مطابق با لیست manyToMany که در کلاس person است
    private List<Person> owners=new ArrayList<>();
//
//    CREATE TABLE Address (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    postalCode VARCHAR(255) ,
//    street VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            registrationNumber VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Person_Address (
//            owners_id BIGINT NOT NULL ,
//            addresses_id BIGINT NOT NULL
//    )
//
//    ALTER TABLE Person
//    ADD CONSTRAINT UK_23enodonj49jm8uwec4i7y37f
//    UNIQUE (registrationNumber)
//
//    ALTER TABLE Person_Address
//    ADD CONSTRAINT FKm7j0bnabh2yr0pe99il1d066u
//    FOREIGN KEY (addresses_id) REFERENCES Address
//
//    ALTER TABLE Person_Address
//    ADD CONSTRAINT FKbn86l24gmxdv2vmekayqcsgup
//    FOREIGN KEY (owners_id) REFERENCES Person
}
