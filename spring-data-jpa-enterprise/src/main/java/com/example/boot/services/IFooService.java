package com.example.boot.services;

import com.example.boot.domain.Foo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * created by Atiye Mousavi
 * Date: 10/9/2021
 * Time: 10:41 AM
 */
public interface IFooService extends IOperations<Foo> {

    Foo retrieveByName(String name);

    Page<Foo> findPaginated(Pageable pageable);
}
