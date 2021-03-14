package com.aojiaoo.admin.entity;

    import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.IdType;

@EqualsAndHashCode(callSuper=true)
@Data
@TableName("role_menu")
public class RoleMenu extends BaseEntity<RoleMenu> {

private static final long serialVersionUID = 1L;

public RoleMenu() {
}

    public RoleMenu(Integer id) {
    this.id=id;
    }

        /**
        * 
        * 表字段： role_menu.role_id
        */
            @TableField(value = "role_id")
        private Integer roleId;
        /**
        * 
        * 表字段： role_menu.rmenu_id
        */
            @TableField(value = "rmenu_id")
        private Integer rmenuId;
        /**
        * 
        * 表字段： role_menu.version
        */
            @TableField(value = "version")
        private Integer version;

}
