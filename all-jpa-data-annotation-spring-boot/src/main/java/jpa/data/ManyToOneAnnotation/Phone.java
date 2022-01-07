package jpa.data.ManyToOneAnnotation;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/24/2021
 * Time: 2:28 PM
 */
@Entity(name = "Phone")
@Data
public class Phone {

    @Id
    //region پراپرتی GeneratedValue
    //	ورودی generator برای استراتژدی تولید کلید اصلی است
    //ورودی strategy برای تعیین نوع جنریت کردن کلید اصلی است
    //endregion
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id",foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private Person person;


//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    person_id BIGINT ,
//    PRIMARY KEY ( id )
// )
//
//    ALTER TABLE Phone
//    ADD CONSTRAINT PERSON_ID_FK
//    FOREIGN KEY (person_id) REFERENCES Person
}
