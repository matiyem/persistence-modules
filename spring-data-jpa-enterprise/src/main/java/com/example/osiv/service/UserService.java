package com.example.osiv.service;

import com.example.osiv.model.BasicUser;

import java.util.Optional;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:11 PM
 */

public interface UserService {
    Optional<BasicUser> findOne(String userName);
}
