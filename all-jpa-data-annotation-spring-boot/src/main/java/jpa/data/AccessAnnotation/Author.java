package jpa.data.AccessAnnotation;


import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


//از آنجایی که کلاس های embeddable ها توسط خودشون مدیریت میشوند و همچنین نحوه دسترسی هم از entity به ارث میرسد هم میتوان
//مانند زیر نحوه دسترسی را override کرد
@Data
@Embeddable
@Access(AccessType.PROPERTY)
public class Author {

    private String firstName;
    private String lastname;

    public Author() {
    }

    public Author(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }
}
