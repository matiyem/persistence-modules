package com.example.hibernate.fetching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 6:59 PM
 */
@Entity
@Table(name = "USER_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionID=1l;

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderDetail other = (OrderDetail) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;

        return true;
    }
}
