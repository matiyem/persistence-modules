package com.example.persistence.dao;

import com.example.persistence.model.Bar;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 10:24 AM
 */
public interface IBarCrudRepository extends CrudRepository<Bar, Serializable> {

}
