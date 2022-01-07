package com.example.persistence.service.comman;

import com.example.persistence.dao.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 2:21 PM
 */
@Transactional(value = "hibernateTransactionManager")
public abstract class AbstractHibernateService<T extends Serializable> extends AbstractService<T> implements IOperations<T> {

    @Override
    public T findOne(final long id) {
        return super.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public void create(final T entity) {
        super.create(entity);
    }

    @Override
    public T update(final T entity) {
        return super.update(entity);
    }

    @Override
    public void delete(final T entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        super.deleteById(entityId);
    }
}
