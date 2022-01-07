package jpa.data.NamedStoredProcedureQueriesAnnotation;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

/**
 * created by Atiye Mousavi
 * Date: 8/26/2021
 * Time: 2:33 PM
 */
@NamedStoredProcedureQuery(
        name="addEmployeeProcedure",
        procedureName="ADD_EMPLOYEE_PROCEDURE",
        resultClasses = { EmployeeEntity.class },
        parameters={
                //ورودی type برای مشخص کردن jdbc type است
                //ورودی mod برای مشخص کردن که آیا پارامتر IN ، INOUT ، OUT یا REF_CURSOR است یا خیر.
                //ورودی name اسم دیتابیسی فیلد ها است
                @StoredProcedureParameter(name="firstName", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="lastName", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="email", type=String.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="departmentId", type=Integer.class, mode=ParameterMode.IN)
        }
)
public class EmployeeEntity  {

    //روش استفاده اس پی به شرح زیر است
//    StoredProcedureQuery storedProcedure = entityManger.createNamedStoredProcedureQuery("ADD_EMPLOYEE_PROCEDURE")
//            .registerStoredProcedureParameter(0 , String.class , ParameterMode.IN)
//            .registerStoredProcedureParameter(1 , String.class, ParameterMode.IN)
//            .registerStoredProcedureParameter(2 , String.class, ParameterMode.IN)
//            .registerStoredProcedureParameter(3 , Integer.class, ParameterMode.IN);
//
//        storedProcedure .setParameter(0, firstName)
//            .setParameter(1, lastName)
//                        .setParameter(2, email)
//                        .setParameter(3, departmentId);
//
//        storedProcedure.execute();

}
