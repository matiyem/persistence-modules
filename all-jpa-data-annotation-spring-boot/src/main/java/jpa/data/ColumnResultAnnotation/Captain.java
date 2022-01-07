package jpa.data.ColumnResultAnnotation;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Captain {
    @EmbeddedId
    private Identity id;
}
