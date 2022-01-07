package com.example.persistence.repository;

/**
 * created by Atiye Mousavi
 * Date: 9/4/2021
 * Time: 11:01 AM
 */
public class FooService implements IFooService{

    private IFooDAO dao;
    @Override
    public Foo create(Foo foo) {
        return dao.save(foo);
    }
}
