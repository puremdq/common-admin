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
     * 英文名，唯一
     * 表字段： sys_role.en_name
     */
    @TableField(value = "en_name")
    private String enName;
    /**
     * 表字段： sys_role.name
     */
    @TableField(value = "name")
    private String name;

}
