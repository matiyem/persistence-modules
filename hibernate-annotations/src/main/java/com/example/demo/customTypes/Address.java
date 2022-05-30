package com.example.demo.customTypes;

import lombok.Data;

import java.util.Objects;

/*
    Create by Atiye Mousavi 
    Date: 5/23/2022
    Time: 12:06 PM
**/
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private int zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode &&
                Objects.equals(addressLine1, address.addressLine1) &&
                Objects.equals(addressLine2, address.addressLine2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, city, country, zipCode);
    }
}
