package com.example.partialUpdate.repository;

import com.example.partialUpdate.model.ContactPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:33 PM
 */
@Repository
public interface ContactPhoneRepository extends CrudRepository<ContactPhone,Long> {
    ContactPhone findById(long id);
    ContactPhone findByCustomerId(long id);
}
