package com.example.multipledb.dao.user;

import com.example.boot.domain.Possession;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 10:25 AM
 */

public interface PossessionRepository extends JpaRepository<Possession,Long> {
}
