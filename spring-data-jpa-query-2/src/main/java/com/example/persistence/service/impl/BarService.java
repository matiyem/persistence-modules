package com.example.persistence.service.impl;

import com.example.persistence.dao.IBarDao;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarService;
import com.example.persistence.service.comman.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BarService extends AbstractHibernateService<Bar> implements IBarService {

    @Autowired
    @Qualifier("barHibernateDao")
    private IBarDao dao;

    public BarService() {
        super();
    }

    // API

    @Override
    protected IOperations<Bar> getDao() {
        return dao;
    }

}
