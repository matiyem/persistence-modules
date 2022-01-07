package jpa.data.ExcludeDefaultListenersAnnotation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Id;

@Entity(name = "Publisher")
@Data
//  این دو annotation برای نادیده گرفتن listener ها است چه لیستنر دیفالت چه از سوپر کلاس
@ExcludeDefaultListeners
@ExcludeSuperclassListeners
public class Publisher extends BaseEntity{

    @Id
    private Long id;
    private String name;

}
