package com.example.persistence.dao.common;

import com.google.common.base.Preconditions;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 4:55 PM
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T> implements IOperations<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T findOne(final long id) {
        return (T)getCurrentSession().get(clazz,id);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public void create(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);

    }

    @Override
    public T update(Serializable entity) {
        Preconditions.checkNotNull(entity);

        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        final T entity=findOne(entityId);
        Preconditions.checkState(entity !=null);

    }
    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
