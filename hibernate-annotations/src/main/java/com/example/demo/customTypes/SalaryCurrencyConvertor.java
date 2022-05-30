package com.example.demo.customTypes;

/*
    Create by Atiye Mousavi 
    Date: 5/24/2022
    Time: 11:14 AM
**/
public class SalaryCurrencyConvertor {

    public static Long convert(Long amount, String oldCurr, String newCurr){
        if (newCurr.equalsIgnoreCase(oldCurr))
            return amount;

        return convertTo();
    }

    private static Long convertTo() {
        return 10L;
    }
}
