package com.example.jpa.enums;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:06 PM
**/
public enum Category {
    SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

    private String code;

    Category(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
