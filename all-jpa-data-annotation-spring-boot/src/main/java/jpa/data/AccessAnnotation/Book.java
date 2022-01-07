package jpa.data.AccessAnnotation;

import lombok.Data;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//این entity بصورت پیش فرض نحوه دسترسی field-base است ولی entity که inject شده بر اساس property است
@Entity(name = "Book")
@Data
public  class Book {
    //هنگام استفاده از field-based access اضافه کردن دیگر entity-level ها بسیار اعطاف پذیر است زیرا
    //hibernate آن بخش را در نظر نمیگیرد.برای حذف فیلدی از بخش حالت پایدار ،میتوان آن را با Transient@ نشانه گذاری کرد

    @Id
    private Long id;
    private String title;
    //این کلاس embeddedable است پس در نتیجه اینجا این annotation را میگذاریم
    @Embedded
    private Author author;

    //وقتی از این استفاده میکنیم یعنی داریم حالت دیفالت آن را override میکنیم
    // @version از طریق فیلد در دسترس است نه از طریق getter آن
    @Access( AccessType.FIELD )
    @Version
    private int version;

    //برای حالتی است که یک collection داریم مانند زیر

    @ElementCollection
    //وقتی مقدار تعریفی ما یک کالکشن است باید به صورت تعریف شود
    @CollectionTable(
            name = "book_author",joinColumns = @JoinColumn(name = "book_id")
    )
    private List<Author> authors = new ArrayList<Author>();

    //@Id
    //اگر @Id بر روی متد قرار گیرد میشود property-based access هایبرنت از متد های read و write استفاده میکند
    //اگر متدهای دیگه ای اضافه بشه شبیه one-to-many باید از transient استفاده شود
    public Long getId() {
        return id;
    }



}
