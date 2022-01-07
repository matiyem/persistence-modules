package jpa.data.AssociationOverrideAnnotation;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Country")
@Data
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    //یک شناسه ای است که بصورت طبیعی یونیک و غیرقابل تکرار است مثل کد ملی شماره تلفن. یا شماره حساب
    //چنین فیلد هایی را اینجوری مارک میکنیم
    @NaturalId
    private String name;
}
