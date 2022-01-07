package jpa.data.TableGeneratorAnnotation;

import javax.persistence.*;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 8:57 PM
 */
@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "table-generator"
    )
    @TableGenerator(
            name =  "table-generator",
            table = "table_identifier",
            pkColumnName = "table_name",
            valueColumnName = "product_id",
            allocationSize = 5
    )
    private Long id;

    @Column(name = "product_name")
    private String name;

    //کد بالا باعث ساخت جدول زیر میشود
//    create table table_identifier (
//            table_name varchar2(255 char) not null,
//    product_id number(19,0),
//    primary key (table_name)
//)
}
