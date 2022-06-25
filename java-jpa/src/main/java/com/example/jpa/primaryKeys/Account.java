package com.example.jpa.primaryKeys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:17 PM
**/
@Entity
@IdClass(AccountId.class)
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private String description;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
