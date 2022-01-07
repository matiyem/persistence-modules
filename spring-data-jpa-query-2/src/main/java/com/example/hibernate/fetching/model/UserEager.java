package com.example.hibernate.fetching.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 7:03 PM
 */
@Entity
@Table(name = "USER")
@Data
public class UserEager implements Serializable {
    private static final long serialVersionID=1L;

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetail=new HashSet<>();

    public UserEager() {
    }

    public UserEager(final Long userId) {
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
        final UserEager other = (UserEager) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
}
