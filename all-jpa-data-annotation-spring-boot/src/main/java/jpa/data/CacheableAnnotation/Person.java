package jpa.data.CacheableAnnotation;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity(name = "Person")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public  class Person {
    //کش لول دو همچنین برای entity هایی که دارای naturalid هم هستند لود میشود
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NaturalId
    @Column(name = "code", unique = true)
    private String code;
}