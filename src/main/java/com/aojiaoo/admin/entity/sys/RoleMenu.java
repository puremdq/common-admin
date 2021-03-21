package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_menu")
public class RoleMenu extends BaseEntity<RoleMenu> {

    private static final long serialVersionUID = 1L;

    public RoleMenu() {
    }

    public RoleMenu(Integer id) {
        this.id = id;
    }

    /**
     * 表字段： sys_role_menu.role_id
     */
    @TableField(value = "role_id")
    private Integer roleId;
    /**
     * 表字段： sys_role_menu.rmenu_id
     */
    @TableField(value = "rmenu_id")
    private Integer rmenuId;

}
