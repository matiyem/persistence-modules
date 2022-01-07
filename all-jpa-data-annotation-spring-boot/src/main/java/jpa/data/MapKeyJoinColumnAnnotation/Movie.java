package jpa.data.MapKeyJoinColumnAnnotation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 8/25/2021
 * Time: 4:05 PM
 */

@Entity(name = "movie")
@Data
public class Movie {
    @Id
    private long id;

    private String title;
}
