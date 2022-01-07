package com.example.persistence.dao.common;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 5:30 PM
 */
@SuppressWarnings("unchecked")
public class AbstractHibernateAuditableDao<T extends Serializable> extends AbstractHibernateDao<T> implements IAuditOperations<T>{
    @Override
    public List<T> getEntitiesRevision(final Number revision) {
        //با استفاده از رابط AuditReader می توان به سابقه حسابرسی یک نهاد دسترسی پیدا کرد ، که می توان آن را با یک EntityManager یا Session باز از طریق AuditReaderFactory بدست آورد:
        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery().forEntitiesAtRevision(clazz, revision);
        final List<T> resultList = query.getResultList();
        return resultList;    }

    @Override
    public List<T> getEntitiesModifiedAtRevision(final Number revision) {
        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery().forEntitiesModifiedAtRevision(clazz, revision);
        final List<T> resultList = query.getResultList();
        return resultList;    }

    @Override
    public List<T> getRevision() {
        final AuditReader auditReader = AuditReaderFactory.get(getCurrentSession());
        final AuditQuery query = auditReader.createQuery().forRevisionsOfEntity(clazz, true, true);
        final List<T> resultList = query.getResultList();
        return resultList;
    }
}
