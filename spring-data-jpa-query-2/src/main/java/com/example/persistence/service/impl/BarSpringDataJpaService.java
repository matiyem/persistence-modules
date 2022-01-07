package com.example.persistence.service.impl;

import com.example.persistence.dao.IBarCrudRepository;
import com.example.persistence.model.Bar;
import com.example.persistence.service.IBarService;
import com.example.persistence.service.comman.AbstractSpringDataJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 9:49 AM
 */
public class BarSpringDataJpaService extends AbstractSpringDataJpaService<Bar> implements IBarService {



    @Autowired
    private IBarCrudRepository dao;


    public BarSpringDataJpaService() {
//        super();
    }

    @Override
    protected CrudRepository<Bar, Serializable> getDao() {
        return dao;
    }
}
