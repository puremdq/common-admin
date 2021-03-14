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
@TableName("user")
public class User extends BaseEntity<User> {

private static final long serialVersionUID = 1L;

public User() {
}

    public User(Integer id) {
    this.id=id;
    }

        /**
        * 
        * 表字段： user.user_name
        */
            @TableField(value = "user_name")
        private String userName;
        /**
        * 
        * 表字段： user.name
        */
            @TableField(value = "name")
        private String name;
        /**
        * 
        * 表字段： user.password
        */
            @TableField(value = "password")
        private String password;
        /**
        * 
        * 表字段： user.salt
        */
            @TableField(value = "salt")
        private String salt;
        /**
        * 
        * 表字段： user.version
        */
            @TableField(value = "version")
        private Integer version;

}
