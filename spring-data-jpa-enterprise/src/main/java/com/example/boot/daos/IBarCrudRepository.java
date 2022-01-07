package com.example.boot.daos;

import com.example.boot.domain.Bar;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 3:50 PM
 */
public interface IBarCrudRepository extends CrudRepository<Bar, Serializable> {
}
