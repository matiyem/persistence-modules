package com.example.persistence.dao.impl;

import com.example.persistence.model.Bar;
import com.example.persistence.dao.IBarDao;
import com.example.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 4:54 PM
 */
@Repository
public class BarDao extends AbstractHibernateDao<Bar> implements IBarDao {

    public BarDao() {
        super();
        setClazz(Bar.class);
    }
}
