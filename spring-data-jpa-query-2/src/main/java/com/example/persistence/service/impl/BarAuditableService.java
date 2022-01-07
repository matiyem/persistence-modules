package com.example.persistence.service.impl;

import com.example.persistence.dao.IBarAuditableDao;
import com.example.persistence.dao.IBarDao;
import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarAuditableService;
import com.example.persistence.service.comman.AbstractHibernateAuditableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:02 PM
 */
public class BarAuditableService extends AbstractHibernateAuditableService<Bar> implements IBarAuditableService {

    @Autowired
    @Qualifier("barHibernateDao")
    private IBarDao dao;

    @Autowired
    @Qualifier("barHibernateAuditableDao")
    private IBarAuditableDao auditableDao;


    @Override
    protected IAuditOperations<Bar> getAuditableDao() {
        return auditableDao;
    }

    @Override
    protected IOperations<Bar> getDao() {
        return dao;
    }
}
