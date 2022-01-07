package jpa.data.ManyToOneAnnotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/24/2021
 * Time: 2:24 PM
 */
@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;
}
