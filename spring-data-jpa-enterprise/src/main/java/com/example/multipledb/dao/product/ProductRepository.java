package com.example.multipledb.dao.product;

import com.example.multipledb.model.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 10:22 AM
 */

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {

    List<Product> findAllByPrice(double price, Pageable pageable);
}
