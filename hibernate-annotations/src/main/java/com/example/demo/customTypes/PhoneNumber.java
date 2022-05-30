package com.example.demo.customTypes;

import java.util.Objects;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 9:54 AM
**/
public class PhoneNumber {
    private final int countryCode;
    private final int cityCode;
    private final int number;

    public PhoneNumber(int countryCode, int cityCode, int number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return countryCode == that.countryCode &&
                cityCode == that.cityCode &&
                number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, cityCode, number);
    }
}
