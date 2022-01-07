package jpa.data.JoinTable;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 8:34 AM
 */
@Entity(name = "Phone")
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private PhoneType type;

    @Column(name = "number")
    private String number;

    private Date since;

}
