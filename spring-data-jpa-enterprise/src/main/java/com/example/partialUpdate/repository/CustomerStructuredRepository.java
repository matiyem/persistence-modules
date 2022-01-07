package com.example.partialUpdate.repository;

import com.example.partialUpdate.model.CustomerStructured;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:36 PM
 */
@Repository
public interface CustomerStructuredRepository extends CrudRepository<CustomerStructured,Long> {
    CustomerStructured findById(long id);

}
