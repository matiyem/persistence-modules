package com.example.persistence.service.impl;

import com.example.persistence.dao.IBarDao;
import com.example.persistence.dao.common.IOperations;
import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarService;
import com.example.persistence.service.comman.AbstractJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * created by Atiye Mousavi
 * Date: 9/5/2021
 * Time: 6:52 PM
 */
public class BarJpaService extends AbstractJpaService<Bar> implements IBarService {

    @Autowired
    @Qualifier("barJpaDao")
    private IBarDao dao;

    public BarJpaService() {
        super();
    }

    @Override
    protected IOperations<Bar> getDao() {
        return dao;
    }
}
