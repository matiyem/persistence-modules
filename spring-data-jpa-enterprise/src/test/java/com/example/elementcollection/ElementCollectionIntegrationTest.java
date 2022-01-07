package com.example.elementcollection;

import com.example.elementCollection.model.Employee;
import com.example.elementCollection.model.Phone;
import com.example.elementCollection.repository.EmployeeRepository;
import com.example.elementCollection.ElementCollectionApplication;
import com.example.elementCollection.model.Employee;
import com.example.elementCollection.model.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElementCollectionApplication.class)
public class ElementCollectionIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void init() {
        Employee employee = new Employee(1, "Fred");
        employee.setPhones(
                Arrays.asList(new Phone("work", "+55", "99999-9999"), new Phone("home", "+55", "98888-8888")));
        employeeRepository.save(employee);
    }

    @After
    public void clean() {
        employeeRepository.remove(1);
    }
//این آزمون هنگامی که سعی می کنیم به لیست تلفن ها دسترسی پیدا کنیم ، به دلیل بسته بودن persistence context ، یک exception را ایجاد می کند.
//
//ما می توانیم این مشکل را با تغییر استراتژی واکشیElementCollection برای استفاده از رویکرد eager حل کنیم. با این حال ، واکشی داده ها eager لزوماً بهترین راه حل نیست ، زیرا داده های تلفن همیشه بارگیری می شوند ، چه به آن نیاز داشته باشیم یا نه.
    @Test(expected = org.hibernate.LazyInitializationException.class)
    public void whenAccessLazyCollection_thenThrowLazyInitializationException() {
        Employee employee = employeeRepository.findById(1);
        assertThat(employee.getPhones().size(), is(2));
    }

    @Test
    public void whenUseJPAQL_thenFetchResult() {
        Employee employee = employeeRepository.findByJPQL(1);
        assertThat(employee.getPhones().size(), is(2));
    }

    @Test
    public void whenUseEntityGraph_thenFetchResult() {
        //با استفاده از entityGraph انجام میشود
        Employee employee = employeeRepository.findByEntityGraph(1);
        assertThat(employee.getPhones().size(), is(2));
    }

    @Test
    @Transactional
    public void whenUseTransaction_thenFetchResult() {
        Employee employee = employeeRepository.findById(1);
        assertThat(employee.getPhones().size(), is(2));
    }
}
