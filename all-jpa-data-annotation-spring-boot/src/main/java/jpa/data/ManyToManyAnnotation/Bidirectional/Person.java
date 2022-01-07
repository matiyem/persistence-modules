package jpa.data.ManyToManyAnnotation.Bidirectional;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 1:20 PM
 */

@Entity(name = "Person")
@Data
public class Person {
    //چون این یک entity بصورت manyToMany است خودش یک جدول سوم میسازد که ایدی های این جدوال را در آن قرار داده است

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;

    //این یک  ManyToMany دو سویه است چون در child عملیات مپ صورت گرفته به عبارتی به این Bidirectional گویند
    //وروردی cascade برای مشخص کردن نوع عملیات است
    //ورودی fetch برای مشخص کردن این است که دیتا مورد نظر باید بصورت lazy لود شود یا بصورت eager لود شود بصورت دیفالت بر روی lazy ست شده است
    //ورودی mapped by برای مشخص کردن  فیلد مالک این رابطه است
    //ورودی targetEntity برای مشخص کردن کلاس هدف این رابطه است
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Address> addresses=new ArrayList<>();


    public void addAddress(Address address) {
        addresses.add( address );
        address.getOwners().add( this );
    }

    public void removeAddress(Address address) {
        addresses.remove( address );
        address.getOwners().remove( this );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals( registrationNumber, person.registrationNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( registrationNumber );
    }
}
