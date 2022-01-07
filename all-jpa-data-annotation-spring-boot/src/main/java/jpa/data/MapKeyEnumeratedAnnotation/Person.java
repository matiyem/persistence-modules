package jpa.data.MapKeyEnumeratedAnnotation;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * created by Atiye Mousavi
 * Date: 8/25/2021
 * Time: 3:29 PM
 */

@Entity(name = "person")
@Data
public class Person {

    @Id
    private Long id;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,orphanRemoval = true)
    @MapKey(name = "type")//این فیلد کلاس phone است
    @MapKeyEnumerated//تایپ استفاده شده برای enum است که بصورت دیفالت بر روی ordinal ست است
    private Map<PhoneType,Phone> phoneRegister=new HashMap<>();

    public void addPhone(Phone phone) {
        phone.setPerson( this );
        phoneRegister.put( phone.getType(), phone );
    }

//    CREATE TABLE Person (
//            id BIGINT NOT NULL ,
//            PRIMARY KEY ( id )
//)
//
//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    since TIMESTAMP ,
//    type INTEGER ,
//    person_id BIGINT ,
//    PRIMARY KEY ( id )
//)
//
//    ALTER TABLE Phone
//    ADD CONSTRAINT FKmw13yfsjypiiq0i1osdkaeqpg
//    FOREIGN KEY (person_id) REFERENCES Person
}
