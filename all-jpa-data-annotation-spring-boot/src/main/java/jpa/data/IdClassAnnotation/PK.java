package jpa.data.IdClassAnnotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PK implements Serializable {


    private String subsystem;
    private String username;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        PK pk = (PK) o;
        return Objects.equals( subsystem, pk.subsystem ) &&
                Objects.equals( username, pk.username );
    }

    @Override
    public int hashCode() {
        return Objects.hash( subsystem, username );
    }
}
