package com.example.jpa.sqlResultSetMapping;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:22 PM
**/
@SqlResultSetMapping(
        name="EmployeeResult",
        entities={
                @EntityResult(
                        entityClass =com.example.jpa.sqlResultSetMapping.Employee.class,
                        fields={@FieldResult(name="id",column="employeeNumber"),
                                @FieldResult(name="name", column="name")}
                )
        }
)
@NamedNativeQuery(
        name="Employees",
        query="SELECT id as employeeNumber, name FROM EMPLOYEE",
        resultSetMapping = "EmployeeResult"
)
@Entity
public class Employee {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
