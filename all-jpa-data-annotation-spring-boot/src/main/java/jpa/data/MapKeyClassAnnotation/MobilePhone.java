package jpa.data.MapKeyClassAnnotation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * created by Atiye Mousavi
 * Date: 8/24/2021
 * Time: 3:58 PM
 */

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MobilePhone implements PhoneNumber{
    static PhoneNumber fromString(String phoneNumber) {
        String[] tokens = phoneNumber.split( "-" );
        if ( tokens.length != 3 ) {
            throw new IllegalArgumentException( "invalid phone number: " + phoneNumber );
        }
        int i = 0;
        return new MobilePhone(
                tokens[i++],
                tokens[i++],
                tokens[i]
        );
    }
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "operator_code")
    private String operatorCode;

    @Column(name = "subscriber_code")
    private String subscriberCode;

    @Override
    public String get() {
        return String.format(
                "%s-%s-%s",
                countryCode,
                operatorCode,
                subscriberCode
        );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        MobilePhone that = (MobilePhone) o;
        return Objects.equals( countryCode, that.countryCode ) &&
                Objects.equals( operatorCode, that.operatorCode ) &&
                Objects.equals( subscriberCode, that.subscriberCode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( countryCode, operatorCode, subscriberCode );
    }
}
