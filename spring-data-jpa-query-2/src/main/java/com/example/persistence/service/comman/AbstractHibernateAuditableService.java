package com.example.persistence.service.comman;

import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.dao.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:08 PM
 */
@Transactional(value = "hibernateTransactionManager")
public abstract class AbstractHibernateAuditableService<T extends Serializable> extends AbstractHibernateService<T> implements IOperations<T>, IAuditOperations<T> {

    @Override
    public List<T> getEntitiesRevision(Number revision) {
        return null;
    }

    @Override
    public List<T> getEntitiesModifiedAtRevision(Number revision) {
        return null;
    }

    @Override
    public List<T> getRevision() {
        return getAuditableDao().getRevision();
    }
    abstract protected IAuditOperations<T> getAuditableDao();
}
