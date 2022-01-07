package com.example.osiv.web;

import com.example.osiv.model.BasicUser;
import lombok.Data;

import java.util.Set;

/**
 * created by Atiye Mousavi
 * Date: 10/10/2021
 * Time: 3:24 PM
 */

@Data
public class DetailedUserDto {
    private Long id;
    private String username;
    private Set<String> permissions;
    public static DetailedUserDto fromEntity(BasicUser user) {
        DetailedUserDto detailed = new DetailedUserDto();
        detailed.setId(user.getId());
        detailed.setUsername(user.getUsername());
        detailed.setPermissions(user.getPermissions());

        return detailed;
    }

}
