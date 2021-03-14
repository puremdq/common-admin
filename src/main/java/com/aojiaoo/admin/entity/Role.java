package com.aojiaoo.admin.entity;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role")
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    public Role() {
    }

    /**
     * 表字段： role.name
     */
    @TableField(value = "name")
    private String name;

}
