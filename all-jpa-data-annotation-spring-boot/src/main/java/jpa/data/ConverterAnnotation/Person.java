package jpa.data.ConverterAnnotation;

import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Person")
@Data
public class Person {
    @Id
    private Long id;

    private String name;

    @Convert( converter = GenderConverter.class )
    public Gender gender;
}
