package com.example.persistence.service.impl;

import com.example.persistence.dao.IChildDao;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Child;
import com.example.persistence.service.IChildService;
import com.example.persistence.service.comman.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends AbstractHibernateService<Child> implements IChildService {

    @Autowired
    private IChildDao dao;

    public ChildService() {
        super();
    }

    // API

    @Override
    protected IOperations<Child> getDao() {
        return dao;
    }

}
