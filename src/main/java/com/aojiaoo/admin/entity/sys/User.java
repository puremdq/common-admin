package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@TableName("sys_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    public User() {
    }


    /**
     * 表字段： sys_user.user_name
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 表字段： sys_user.name
     */
    @TableField(value = "name")
    private String name;
    /**
     * 表字段： sys_user.password
     */
    @TableField(value = "password")
    private String password;
    /**
     * 表字段： sys_user.salt
     */
    @TableField(value = "salt")
    private String salt;

}
