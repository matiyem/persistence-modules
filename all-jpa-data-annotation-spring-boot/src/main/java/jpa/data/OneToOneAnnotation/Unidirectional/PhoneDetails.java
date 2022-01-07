package jpa.data.OneToOneAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 3:59 PM
 */
@Entity(name = "phoneDetails")
@Data
public class PhoneDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;
}
