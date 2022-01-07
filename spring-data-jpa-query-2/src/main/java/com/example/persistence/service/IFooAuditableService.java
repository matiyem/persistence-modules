package com.example.persistence.service;

import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.model.Foo;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:28 PM
 */
public interface IFooAuditableService extends IFooService, IAuditOperations<Foo> {
}
