package com.example.jpa.model;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:15 PM
**/
@Entity
@Table(name = "CAR")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "findByYearProcedure",
                procedureName = "FIND_CAR_BY_YEAR",
                resultClasses = { Car.class },
                parameters = { @StoredProcedureParameter(name = "p_year", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "output", type = Integer.class, mode = ParameterMode.OUT)}) })
public class Car {
    private long id;
    private String model;
    private Integer year;



    public Car(final String model, final Integer year) {
        this.model = model;
        this.year = year;
    }

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, scale = 0)
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }


}
