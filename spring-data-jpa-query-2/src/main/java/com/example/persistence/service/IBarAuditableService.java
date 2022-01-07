package com.example.persistence.service;

import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.model.Bar;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 2:52 PM
 */
public interface IBarAuditableService extends IBarService, IAuditOperations<Bar> {
}
