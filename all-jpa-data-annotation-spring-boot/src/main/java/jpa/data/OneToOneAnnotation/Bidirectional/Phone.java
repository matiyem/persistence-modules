package jpa.data.OneToOneAnnotation.Bidirectional;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 4:29 PM
 */
@Entity(name = "phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @OneToOne(
            mappedBy = "phone",//این توسط parent ست میشود و اسم آن مطابق با اسمی است که در child گذاشته شده است
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PhoneDetails details;


    public void addDetails(PhoneDetails details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {
        if ( details != null ) {
            details.setPhone( null );
            this.details = null;
        }
    }
//    CREATE TABLE Phone (
//            id BIGINT NOT NULL ,
//            number VARCHAR(255) ,
//    PRIMARY KEY ( id )
//)
//
//    CREATE TABLE PhoneDetails (
//            id BIGINT NOT NULL ,
//            provider VARCHAR(255) ,
//    technology VARCHAR(255) ,
//    phone_id BIGINT ,
//    PRIMARY KEY ( id )
//)
//
//    ALTER TABLE PhoneDetails
//    ADD CONSTRAINT FKeotuev8ja8v0sdh29dynqj05p
//    FOREIGN KEY (phone_id) REFERENCES Phone
}
