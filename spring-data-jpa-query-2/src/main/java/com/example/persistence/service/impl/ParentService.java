package com.example.persistence.service.impl;

import com.example.persistence.dao.IParentDao;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Parent;
import com.example.persistence.service.IParentService;
import com.example.persistence.service.comman.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService extends AbstractHibernateService<Parent> implements IParentService {

    @Autowired
    private IParentDao dao;

    public ParentService() {
        super();
    }

    // API

    @Override
    protected IOperations<Parent> getDao() {
        return dao;
    }

}
