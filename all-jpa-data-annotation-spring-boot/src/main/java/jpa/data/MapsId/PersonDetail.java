package jpa.data.MapsId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 2:16 PM
 */
@Entity(name = "PersonDetail")
public class PersonDetail {
    @Id
    private Long id;

    private String nickName;


    @OneToOne
    //فقط با oneToone و @ManyToOne استفاده میشود
    @MapsId//از ایدی این کلاس برای مپ کردن استفاده میکند
    private Person person;
}
