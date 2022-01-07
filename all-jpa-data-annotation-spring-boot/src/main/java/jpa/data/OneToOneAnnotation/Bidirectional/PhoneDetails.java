package jpa.data.OneToOneAnnotation.Bidirectional;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 4:30 PM
 */
@Entity(name = "PhoneDetails ")
@Data
public class PhoneDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    private Phone phone;
}
