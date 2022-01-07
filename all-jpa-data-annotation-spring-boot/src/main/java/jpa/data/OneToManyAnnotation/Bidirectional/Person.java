package jpa.data.OneToManyAnnotation.Bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 3:33 PM
 */
@Entity(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    //Getters and setters are omitted for brevity

    public void addPhone(Phone phone) {
        phones.add( phone );
        phone.setPerson( this );
    }

    public void removePhone(Phone phone) {
        phones.remove( phone );
        phone.setPerson( null );
    }

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
//)
//
//    ALTER TABLE Phone
//    ADD CONSTRAINT UK_l329ab0g4c1t78onljnxmbnp6
//    UNIQUE (number)
//
//    ALTER TABLE Phone
//    ADD CONSTRAINT FKmw13yfsjypiiq0i1osdkaeqpg
//    FOREIGN KEY (person_id) REFERENCES Person
}
