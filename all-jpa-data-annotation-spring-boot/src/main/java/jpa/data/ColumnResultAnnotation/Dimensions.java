package jpa.data.ColumnResultAnnotation;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Dimensions {
    private int length;
    private int width;
}
