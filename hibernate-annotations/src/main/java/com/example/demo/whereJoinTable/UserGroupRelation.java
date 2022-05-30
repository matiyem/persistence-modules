package com.example.demo.whereJoinTable;

import javax.persistence.*;
import java.io.Serializable;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 11:39 AM
**/
@Entity(name = "r_user_group")
public class UserGroupRelation implements Serializable {
    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private final Long userId;

    @Id
    @Column(name = "group_id",insertable = false,updatable = false)
    private final Long groupId;

    @Enumerated(EnumType.STRING)
    private final UserGroupRole role;

    public UserGroupRelation(Long userId, Long groupId, UserGroupRole role) {
        this.userId = userId;
        this.groupId = groupId;
        this.role = role;
    }
}
