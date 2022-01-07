package com.example.partialUpdate.model;

import javax.persistence.*;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:31 PM
 */
@Entity
public class CustomerStructured {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = ContactPhone.class, mappedBy = "customerId")
    public List<ContactPhone> contactPhones;

    @Override public String toString() {
        return String.format("Customer %s, Phone: %s",
                this.name, this.contactPhones.stream()
                        .map(e -> e.toString()).reduce("", String::concat));
    }
}
