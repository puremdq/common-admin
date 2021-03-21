package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    public Role() {
    }

    /**
     * 表字段： sys_role.name
     */
    @TableField(value = "name")
    private String name;

}
