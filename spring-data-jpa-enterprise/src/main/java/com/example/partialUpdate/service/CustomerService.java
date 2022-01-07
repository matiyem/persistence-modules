package com.example.partialUpdate.service;

import com.example.partialUpdate.model.ContactPhone;
import com.example.partialUpdate.model.Customer;
import com.example.partialUpdate.model.CustomerDto;
import com.example.partialUpdate.model.CustomerStructured;
import com.example.partialUpdate.repository.ContactPhoneRepository;
import com.example.partialUpdate.repository.CustomerRepository;
import com.example.partialUpdate.repository.CustomerStructuredRepository;
import com.example.partialUpdate.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:37 PM
 */
@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository repo;
    @Autowired
    CustomerStructuredRepository repo2;
    @Autowired
    ContactPhoneRepository repo3;
    //برای اینکه فقط مقادیری که تغییر کرده اند شناسایی و ذخیره شود
    @Autowired
    CustomerMapper mapper;

    public Customer getCustomer(long id) {
        return repo.findById(id);
    }

    public void updateCustomerWithCustomQuery(long id, String phone) {
        repo.updatePhone(id, phone);
    }

    public Customer addCustomer(String name) {
        Customer myCustomer = new Customer();
        myCustomer.name = name;
        repo.save(myCustomer);
        return myCustomer;
    }

    public Customer updateCustomer(long id, String phone) {
        Customer myCustomer = repo.findById(id);
        myCustomer.phone = phone;
        repo.save(myCustomer);
        return myCustomer;
    }

    public Customer addCustomer(CustomerDto dto) {
        Customer myCustomer = new Customer();
        mapper.updateCustomerFromDto(dto, myCustomer);
        repo.save(myCustomer);
        return myCustomer;
    }

    public Customer updateCustomer(CustomerDto dto) {
        Customer myCustomer = repo.findById(dto.getId());
        mapper.updateCustomerFromDto(dto, myCustomer);
        repo.save(myCustomer);
        return myCustomer;
    }

    public CustomerStructured addCustomerStructured(String name) {
        CustomerStructured myCustomer = new CustomerStructured();
        myCustomer.name = name;
        repo2.save(myCustomer);
        return myCustomer;
    }

    public void addCustomerPhone(long customerId, String phone) {
        ContactPhone myPhone = new ContactPhone();
        myPhone.phone = phone;
        myPhone.customerId =  customerId;
        repo3.save(myPhone);
    }

    public CustomerStructured updateCustomerStructured(long id, String name) {
        CustomerStructured myCustomer = repo2.findById(id);
        myCustomer.name = name;
        repo2.save(myCustomer);
        return myCustomer;
    }

}
