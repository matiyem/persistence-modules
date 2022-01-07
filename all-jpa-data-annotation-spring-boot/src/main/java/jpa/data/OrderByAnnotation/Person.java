package jpa.data.OrderByAnnotation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 4:43 PM
 */
@Entity(name = "person")
public class Person {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("number")//لیست زیر بر اساس فیلد name مرتب میشود
    //همچنین میتوان بصورت ترکیبی هم مانند زیر از آن استفاده کرد
//    @OrderBy("number ASC, type DESC")
    private List<Phone> phones = new ArrayList<>();

}
