package com.example.persistence.dao.impl;

import com.example.persistence.dao.IChildDao;
import com.example.persistence.dao.common.AbstractHibernateDao;
import com.example.persistence.model.Child;
import org.springframework.stereotype.Repository;

@Repository
public class ChildDao extends AbstractHibernateDao<Child> implements IChildDao {

    public ChildDao() {
        super();

        setClazz(Child.class);
    }

    // API

}
