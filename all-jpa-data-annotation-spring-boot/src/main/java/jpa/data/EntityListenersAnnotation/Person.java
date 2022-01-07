package jpa.data.EntityListenersAnnotation;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
//یک سری از annotation هارو میشه در یک کلاس دیگه استفاده ولی برای متصل کردن اون کلاس به entity مربوطه 
@EntityListeners(LastUpdateListener.class)
@Data
public class Person {

    @Id
    private Long id;
    private String name;
    private Date dateOfBrith;

    @Transient
    private long age;

    private Date lastUpdate;

    @PostLoad
    public void calculateAge(){
        age= ChronoUnit.YEARS.between(LocalDateTime.ofInstant(Instant.ofEpochMilli(dateOfBrith.getTime()), ZoneOffset.UTC), LocalDateTime.now());
    }
}
