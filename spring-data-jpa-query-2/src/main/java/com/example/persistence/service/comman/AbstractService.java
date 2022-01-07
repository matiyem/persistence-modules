package com.example.persistence.service.comman;

import com.example.persistence.dao.common.IOperations;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/5/2021
 * Time: 7:01 PM
 */
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    @Override
    public T findOne(long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(T entity) {
        getDao().create(entity);

    }

    @Override
    public T update(T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);

    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);

    }

    protected abstract IOperations<T> getDao();
}
