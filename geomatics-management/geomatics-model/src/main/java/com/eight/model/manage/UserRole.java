package com.eight.model.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserRole {
    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Long roleId;
}