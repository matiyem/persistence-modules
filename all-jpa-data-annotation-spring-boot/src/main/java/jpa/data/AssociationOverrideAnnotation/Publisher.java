package jpa.data.AssociationOverrideAnnotation;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Data
public class Publisher {

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}
