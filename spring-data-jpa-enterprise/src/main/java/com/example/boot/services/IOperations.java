package com.example.boot.services;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 3:16 PM
 */
public interface IOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    Page<T> findPaginated(int page,int size);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
