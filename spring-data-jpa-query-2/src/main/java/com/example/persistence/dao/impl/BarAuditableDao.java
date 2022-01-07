package com.example.persistence.dao.impl;

import com.example.persistence.model.Bar;
import com.example.persistence.dao.IBarAuditableDao;
import com.example.persistence.dao.common.AbstractHibernateAuditableDao;

import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 5:29 PM
 */
public class BarAuditableDao extends AbstractHibernateAuditableDao<Bar> implements IBarAuditableDao {
    public BarAuditableDao() {
        super();
        setClazz(Bar.class);
    }

    @Override
    public List<Bar> getRevision() {
        final List<Bar> resultList = super.getRevision();
        for (final Bar bar : resultList) {
            bar.getFooSet().size(); // force FooSet initialization
        }
        return resultList;
    }
}
