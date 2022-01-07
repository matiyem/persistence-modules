package jpa.data.IdClassAnnotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "SystemUser")
@IdClass(PK.class)//در اصل داریم میگیم فیلد های این کلاس id هستند که بصورت زیر تعریف میشوند
public class SystemUser {
    @Id
    private String subsystem;

    @Id
    private String username;

    private String name;

    //در کلاس pk اگر کانستراکتور وجود نداشته باشد خطا میدهد
    public PK getId(){
        return new PK(subsystem,
                username);
    }
    public void setId(PK id) {
        this.subsystem = id.getSubsystem();
        this.username = id.getUsername();
    }

}
