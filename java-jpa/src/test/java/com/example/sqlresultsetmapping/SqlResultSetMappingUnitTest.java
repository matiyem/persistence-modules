package com.example.sqlresultsetmapping;

import com.example.jpa.sqlResultSetMapping.Employee;
import com.example.jpa.sqlResultSetMapping.ScheduledDay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SqlResultSetMappingUnitTest {

    private static EntityManager em;
    private static EntityManagerFactory emFactory;

    @BeforeAll
    public static void setup() {
        emFactory = Persistence.createEntityManagerFactory("java-jpa-scheduled-day");
        em = emFactory.createEntityManager();
    }

    @Test
    public void whenNamedQuery_thenColumnResult() {
        List<Long> employeeIds = em.createNamedQuery("FridayEmployees").getResultList();
        assertEquals(2, employeeIds.size());
    }

    @Test
    public void whenNamedQuery_thenConstructorResult() {
        List<ScheduledDay> scheduleDays = Collections.checkedList(em.createNamedQuery("Schedules", ScheduledDay.class).getResultList(), ScheduledDay.class);
        assertEquals(2, scheduleDays.size());
        assertTrue(scheduleDays.stream().allMatch(c -> c.getEmployeeId().longValue() == 3));
    }

    @Test
    public void whenNamedQuery_thenSingleEntityResult() {
        List<Employee> employees = Collections.checkedList(em.createNamedQuery("Employees").getResultList(), Employee.class);
        assertEquals(3, employees.size());
        assertTrue(employees.stream().allMatch(c -> c.getClass() == Employee.class));
    }

    @Test
    public void whenNamedQuery_thenMultipleEntityResult() {
        final Query query = em.createNativeQuery("SELECT e.id, e.name, d.id, d.employeeId, d.dayOfWeek "
                                                    + " FROM employee e, schedule_days d "
                                                    + " WHERE e.id = d.employeeId", "EmployeeScheduleResults");
        List<Object[]> results = query.getResultList();
        assertEquals(4, results.size());
        assertTrue(results.get(0).length == 2);

        Employee emp = (Employee) results.get(1)[0];
        ScheduledDay day = (ScheduledDay) results.get(1)[1];

        assertTrue(day.getEmployeeId() == emp.getId());
    }

    @AfterAll
    public static void destroy() {

        if (em != null) {
            em.close();
        }
        if (emFactory != null) {
            emFactory.close();
        }
    }
}
