package jpa.data.LobOrBlobAnnotation;

import lombok.Data;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;

/**
 * created by Atiye Mousavi
 * Date: 8/23/2021
 * Time: 10:51 AM
 */

@Entity(name = "Product")
@Data
public class Product {

    @Id
    private Integer id;

    private String name;

    @Lob
    private Blob image;
    //همچنین میتوان فیلد lob را بصورت []byte هم تعریف کرد
//  private byte[] image;





//    برای insert فیلد های lob باید به یکی از چند طریق زیر استفاده کنیم
//    byte[] image = new byte[]{1, 2, 3};
//
//    Product product = new Product();
//product.setId(1);
//product.setName("Mobile phone");
//
//product.setImage(BlobProxy.generateProxy(image ));
//
//entityManager.persist(product );

//    ورودی متد BlobProxy.generateProxy یا بصورت inputStream یا بصورت byte[] استفاده میشود




//    Product product = entityManager.find( Product.class, productId );
//
//try (InputStream inputStream = product.getImage().getBinaryStream()) {
//    assertArrayEquals(new byte[] {1, 2, 3}, toBytes( inputStream ) );
//}
}
