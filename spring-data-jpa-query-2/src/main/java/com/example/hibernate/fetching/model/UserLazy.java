package com.example.hibernate.fetching.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 8:36 AM
 */
@Entity
@Table(name = "USER")
@Data
public class UserLazy implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    //Eager Loading is a design pattern in which data initialization occurs on the spot
    //Lazy Loading is a design pattern which is used to defer initialization of an object as long as it's possible

    // In eager loading strategy, if we load the User data, it will also load up all orders associated with it and will store it in a memory.
    //
    //But, when lazy loading is enabled, if we pull up a UserLazy, OrderDetail data won't be initialized and loaded into a memory until an explicit call is made to it.
    @OneToMany(fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetail=new HashSet<>();
    public UserLazy() {
    }

    public UserLazy(final Long userId) {
        super();
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserLazy other = (UserLazy) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }


}
