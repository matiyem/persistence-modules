package com.example.demo.customTypes;

import java.util.Objects;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 10:53 AM
**/
public class Salary {
    private Long amount;
    private String currency;
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(amount, salary.amount) &&
                Objects.equals(currency, salary.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
