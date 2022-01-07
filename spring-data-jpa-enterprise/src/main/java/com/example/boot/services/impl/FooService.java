package com.example.boot.services.impl;

import com.example.boot.daos.IFooDao;
import com.example.boot.domain.Foo;
import com.example.boot.services.IFooService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 9:31 AM
 */
@Service
@Transactional
public class FooService extends AbstractService<Foo> implements IFooService {
    @Autowired
    private IFooDao dao;

    public FooService() {
        super();
    }

    @Override
    public Foo retrieveByName(String name) {
        return dao.retrieveByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Foo> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    //The findAll(Pageable pageable) method by default returns a Page<T> object.
    //However, we can choose to return either a Page<T>, a Slice<T>,
    // or a List<T> from any of our custom methods returning paginated data.
    //A Slice only knows whether the next slice is available or not.
    public Page<Foo> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    protected PagingAndSortingRepository<Foo, Long> getDao() {
        return dao;
    }
}
