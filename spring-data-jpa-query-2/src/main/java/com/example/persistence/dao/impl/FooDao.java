package com.example.persistence.dao.impl;

import com.example.persistence.dao.IFooDao;
import com.example.persistence.dao.common.AbstractHibernateDao;
import com.example.persistence.model.Foo;
import org.springframework.stereotype.Repository;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 5:39 PM
 */
@Repository
public class FooDao extends AbstractHibernateDao<Foo> implements IFooDao {
    public FooDao() {
        super();
        setClazz(Foo.class);
    }
}
