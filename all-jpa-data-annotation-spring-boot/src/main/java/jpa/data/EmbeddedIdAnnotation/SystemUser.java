package jpa.data.EmbeddedIdAnnotation;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "SystemUser")
@Data
public class SystemUser {

    @EmbeddedId//وقتی کلید های ما بیشتر از یکی است از این روش استفاده میکنیم
    private PK pk;
    private String name;


}
