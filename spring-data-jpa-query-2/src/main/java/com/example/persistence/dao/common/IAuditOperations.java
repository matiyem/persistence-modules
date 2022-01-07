package com.example.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 2:53 PM
 */
public interface IAuditOperations<T extends Serializable> {

    List<T> getEntitiesRevision(Number revision);
    List<T> getEntitiesModifiedAtRevision(Number revision);
    List<T> getRevision();

}
