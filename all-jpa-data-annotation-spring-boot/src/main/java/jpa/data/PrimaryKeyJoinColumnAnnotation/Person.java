package jpa.data.PrimaryKeyJoinColumnAnnotation;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 6:42 PM
 */
@Data
@Entity(name = "person")
public class Person {
    @Id
    private Long id;

    @NaturalId
    private String registrationNumber;

    public Person() {}

    public Person(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
