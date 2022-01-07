package jpa.data.CacheableAnnotation;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity(name = "Phone")
@Cacheable
//شبیه به استراتژی خواندن و نوشتن است ، اما ممکن است گاه به گاه با دسترسی همزمان به یک موجودیت ، خواندن قدیمی انجام شود. اگر برنامه به ندرت داده های یکسانی را به طور همزمان به روز کند و به جداسازی دقیق تراکنش نیازی نباشد ، انتخاب این استراتژی ممکن است مناسب باشد. پیاده سازی ها ممکن است از بهینه سازی عملکردی استفاده کنند که از تضمین سازگاری آرام استفاده می کند.
//ورودیCacheConcurrencyStrategy برای استفاده از استراتژی ـن است
//ورودی include مشخص میکند که شامل پراپرتی های lazy بشود یا نشود
//ورودی Region برای یک regon name است
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String mobail;

    //کلید خارجی ایناها در کش ذخیره نمیشوند
    @ManyToOne
    private Person person;

    @Version//برای تعیین ورژن مورد استفاده
    private int version;
}
