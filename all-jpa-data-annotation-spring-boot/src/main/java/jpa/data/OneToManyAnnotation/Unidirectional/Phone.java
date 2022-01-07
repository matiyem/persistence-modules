package jpa.data.OneToManyAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 2:58 PM
 */
@Data
@Entity(name = "phone")
public class Phone {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

}
