package com.example.persistence.dao.common;

import com.google.common.base.Preconditions;

import java.io.Serializable;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:55 PM
 */
public abstract class AbstractDao<T extends Serializable> implements IOperations<T> {
    protected Class<T> clazz;
    protected final void setClazz(final Class<T> clazzToSet){
        clazz = Preconditions.checkNotNull(clazzToSet);
    }
}
