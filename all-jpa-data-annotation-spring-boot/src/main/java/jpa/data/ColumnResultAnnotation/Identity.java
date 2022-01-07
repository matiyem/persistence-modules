package jpa.data.ColumnResultAnnotation;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Identity implements Serializable {
    private String firstname;
    private String lastName;

    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        final Identity identity = (Identity) o;

        if ( !firstname.equals( identity.firstname ) ) return false;
        if ( !lastName.equals( identity.lastName ) ) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = firstname.hashCode();
        result = 29 * result + lastName.hashCode();
        return result;
    }
}
