package jpa.data.MapsId;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 1:23 PM
 */
@Entity(name = "Person")
@Data
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
