package com.example.boot.services.impl;

import com.example.boot.services.IOperations;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 9:14 AM
 */
@Transactional
public abstract  class AbstractService<T extends Serializable> implements IOperations<T> {
    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {
        return getDao().findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public Page<T> findPaginated(final int page,final int size) {
        return getDao().findAll(PageRequest.of(page, size));
    }

    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);

    }

    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }
    protected  abstract PagingAndSortingRepository<T ,Long> getDao();
}
