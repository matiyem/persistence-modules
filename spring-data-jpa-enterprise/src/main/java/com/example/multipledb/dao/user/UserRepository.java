package com.example.multipledb.dao.user;

import com.example.multipledb.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 10:26 AM
 */

public interface UserRepository extends JpaRepository<User,Integer> {
}
