package jpa.data.ForeignKeyAnnotation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Person")
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
}
