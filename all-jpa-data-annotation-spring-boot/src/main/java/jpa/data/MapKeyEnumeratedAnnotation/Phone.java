package jpa.data.MapKeyEnumeratedAnnotation;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * created by Atiye Mousavi
 * Date: 8/25/2021
 * Time: 3:33 PM
 */
@Entity(name = "phone")
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private PhoneType type;

    @Column(name = "number")
    private String number;

    private Date since;

    @ManyToOne
    private Person person;
}
