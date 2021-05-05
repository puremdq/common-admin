package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole extends BaseEntity<UserRole> {

    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     * 表字段： sys_user_role.user_name
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 角色id
     * 表字段： sys_user_role.role_en_name
     */
    @TableField(value = "role_en_name")
    private String roleEnName;

}
