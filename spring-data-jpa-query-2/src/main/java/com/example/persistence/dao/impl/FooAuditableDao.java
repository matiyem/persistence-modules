package com.example.persistence.dao.impl;

import com.example.persistence.dao.IFooAuditableDao;
import com.example.persistence.dao.common.AbstractHibernateAuditableDao;
import com.example.persistence.model.Foo;

/**
 * created by Atiye Mousavi
 * Date: 9/8/2021
 * Time: 12:18 PM
 */
public class FooAuditableDao extends AbstractHibernateAuditableDao<Foo> implements IFooAuditableDao {
    public FooAuditableDao(){
        super();
        setClazz(Foo.class);
    }
}
