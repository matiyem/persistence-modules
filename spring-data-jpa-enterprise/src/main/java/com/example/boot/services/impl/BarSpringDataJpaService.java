package com.example.boot.services.impl;

import com.example.boot.daos.IBarCrudRepository;
import com.example.boot.domain.Bar;
import com.example.boot.services.IBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 3:29 PM
 */
public class BarSpringDataJpaService extends AbstractSpringDataJpaService<Bar> implements IBarService {

    @Autowired
    private IBarCrudRepository dao;


    @Override
    protected CrudRepository<Bar, Serializable> getDao() {
        return dao;
    }

    @Override
    public Page<Bar> findPaginated(int page, int size) {
        throw  new UnsupportedOperationException("Not implemented yet");
    }
}
