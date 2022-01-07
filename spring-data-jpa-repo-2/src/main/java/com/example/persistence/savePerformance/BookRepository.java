package com.example.persistence.savePerformance;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by Atiye Mousavi
 * Date: 9/4/2021
 * Time: 3:07 PM
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
