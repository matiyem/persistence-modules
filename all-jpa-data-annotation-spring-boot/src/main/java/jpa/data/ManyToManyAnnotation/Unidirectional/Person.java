package jpa.data.ManyToManyAnnotation.Unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 11:07 AM
 */

@Entity(name = "Person")
@Data
public class Person {


    @Id
    @GeneratedValue
    private Long id;

    //مانند oneToMany این annotation هم توسط owner مدیریت میشود
    //وقتی یک رکورد از parent پاک میشود رکورد وابسته آن هم پاک میشود
    //این ManyToMany یک طرفه است زیرا در child عملیات مپ صورت نگرفته است به عبارتی به آن  Unidirectional گویند
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Address> addresses=new ArrayList<>();
}
