package com.example.persistence.dao;

import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.model.Foo;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:42 PM
 */
public interface IFooAuditableDao extends IFooDao, IAuditOperations<Foo> {
}
