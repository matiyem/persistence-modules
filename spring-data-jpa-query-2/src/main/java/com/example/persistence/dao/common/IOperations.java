package com.example.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/5/2021
 * Time: 4:05 PM
 */

public interface IOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
