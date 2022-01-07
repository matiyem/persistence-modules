package com.example.persistence.service.impl;

import com.example.persistence.dao.IFooDao;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Foo;
import com.example.persistence.service.IFooService;
import com.example.persistence.service.comman.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 2:20 PM
 */
public class FooService extends AbstractHibernateService<Foo> implements IFooService {

    @Autowired
    @Qualifier("fooHibernateDao")
    private IFooDao dao;

    public FooService(){
        super();
    }

    @Override
    protected IOperations<Foo> getDao() {
        return dao;
    }
}
