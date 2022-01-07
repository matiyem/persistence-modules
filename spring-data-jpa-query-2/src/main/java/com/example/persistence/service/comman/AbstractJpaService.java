package com.example.persistence.service.comman;

import com.example.persistence.dao.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/5/2021
 * Time: 6:58 PM
 */
@Transactional(value = "jpaTransactionManager")
public abstract class AbstractJpaService<T extends Serializable> extends AbstractService<T> implements IOperations<T> {

    @Override
    public T findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public void create(T entity) {
        super.create(entity);
    }

    @Override
    public T update(T entity) {
        return super.update(entity);
    }

    @Override
    public void delete(T entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        super.deleteById(entityId);
    }


}
