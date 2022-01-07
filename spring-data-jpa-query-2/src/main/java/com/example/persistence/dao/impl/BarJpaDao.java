package com.example.persistence.dao.impl;

import com.example.persistence.model.Bar;
import com.example.persistence.dao.IBarDao;
import com.example.persistence.dao.common.AbstractJpaDao;
import org.springframework.stereotype.Repository;

/**
 * created by Atiye Mousavi
 * Date: 9/6/2021
 * Time: 3:53 PM
 */
@Repository
public class BarJpaDao extends AbstractJpaDao<Bar> implements IBarDao {

    public BarJpaDao(){
        super();
        setClazz(Bar.class);
    }
}
