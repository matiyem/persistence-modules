package com.example.persistence.service.impl;

import com.example.persistence.dao.IFooAuditableDao;
import com.example.persistence.dao.IFooDao;
import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Foo;
import com.example.persistence.service.IFooAuditableService;
import com.example.persistence.service.comman.AbstractHibernateAuditableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:36 PM
 */
public class FooAuditableService extends AbstractHibernateAuditableService<Foo> implements IFooAuditableService {

    @Autowired
    @Qualifier("fooHibernateDao")
    private IFooDao dao;

    @Autowired
    @Qualifier("fooHibernateAuditableDao")
    private IFooAuditableDao auditDao;

    public FooAuditableService(){
        super();
    }


    @Override
    protected IAuditOperations<Foo> getAuditableDao() {
        return auditDao;
    }

    @Override
    protected IOperations<Foo> getDao() {
        return dao;
    }
}
