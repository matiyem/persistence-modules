package com.example.persistence.dao.impl;

import com.example.persistence.dao.IParentDao;
import com.example.persistence.dao.common.AbstractHibernateDao;
import com.example.persistence.model.Parent;
import org.springframework.stereotype.Repository;

@Repository
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

    public ParentDao() {
        super();

        setClazz(Parent.class);
    }

    // API

}
