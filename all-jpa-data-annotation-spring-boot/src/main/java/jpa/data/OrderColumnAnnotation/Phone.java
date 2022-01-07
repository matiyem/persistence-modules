package jpa.data.OrderColumnAnnotation;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 4:50 PM
 */
@Entity(name = "phone")
@Data
public class Phone {
    @Id
    private Long id;

    private String type;

    @Column(name = "`number`")
    private String number;
}
