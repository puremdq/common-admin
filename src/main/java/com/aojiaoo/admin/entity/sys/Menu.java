package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity<Menu> {

    private static final long serialVersionUID = 1L;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    /**
     * 菜单名
     * 表字段： sys_menu.name
     */
    @TableField(value = "name")
    private String name;
    /**
     * 父级菜单id
     * 表字段： sys_menu.parent_id
     */
    @TableField(value = "parent_id")
    private Integer parentId;
    /**
     * 是否显示
     * 表字段： sys_menu.is_show
     */
    @TableField(value = "is_show")
    private Byte isShow;
    /**
     * 表字段： sys_menu.url
     */
    @TableField(value = "url")
    private String url;
    /**
     * 图标
     * 表字段： sys_menu.icon
     */
    @TableField(value = "icon")
    private String icon;

}
