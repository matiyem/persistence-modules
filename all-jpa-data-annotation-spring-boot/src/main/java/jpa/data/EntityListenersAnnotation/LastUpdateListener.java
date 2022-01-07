package jpa.data.EntityListenersAnnotation;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class LastUpdateListener {
    //این annotation ها رو میشه با هم دیگه هم استفاده کرد
    @PreUpdate
    @PrePersist
    public void setLastUpdate(Person p){
        //اگر runtimeException برگردانند باید کل transaction ، رول بک شود
        //در این متد ها نباید entityManger و یا متد Qery کال شود
        p.setLastUpdate(new Date());
    }
}
