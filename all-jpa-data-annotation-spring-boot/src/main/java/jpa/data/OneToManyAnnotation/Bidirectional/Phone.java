package jpa.data.OneToManyAnnotation.Bidirectional;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 3:35 PM
 */
@Entity(name = "phone")
@Data
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    @Column(name = "number", unique = true)
    private String number;

    @ManyToOne//این در قسمت child قرار میگیرد
    private Person person;

    //Getters and setters are omitted for brevity

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals( number, phone.number );
    }

    @Override
    public int hashCode() {
        return Objects.hash( number );
    }
}
