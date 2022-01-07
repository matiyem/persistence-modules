package com.example.persistence.dao;

import com.example.persistence.dao.common.IAuditOperations;
import com.example.persistence.model.Bar;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:24 PM
 */
public interface IBarAuditableDao extends IBarDao, IAuditOperations<Bar> {
}
