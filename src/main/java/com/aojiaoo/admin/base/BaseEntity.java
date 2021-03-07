package com.aojiaoo.admin.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
public abstract class BaseEntity<E> implements Serializable {
    public static final int DEL_FLAG_NORMAL = 0;
    public static final int DEL_FLAG_DELETED = 1;

    @Getter
    @Setter
    protected Integer id;

    protected Date createTime;

    protected Date updateTime;

    protected Integer createBy;
    protected Integer updateBy;

    protected String remarks;//备注

    @TableLogic
    @JsonIgnore
    protected int delFlag = BaseEntity.DEL_FLAG_NORMAL;


}
