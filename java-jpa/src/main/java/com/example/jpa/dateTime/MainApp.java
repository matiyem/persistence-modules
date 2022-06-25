package com.example.jpa.dateTime;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 1:53 PM
**/
public class MainApp {

    public static void main(String[] args) {
        DateTimeEntityRepository dateTimeEntityRepository=new DateTimeEntityRepository();

        dateTimeEntityRepository.save(100L);

        JPA22DateTimeEntity dateTimeEntity=dateTimeEntityRepository.find(100L);

        dateTimeEntityRepository.clean();
    }
}
