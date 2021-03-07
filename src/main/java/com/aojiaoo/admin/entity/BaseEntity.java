package com.aojiaoo.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    protected int id;
    protected Date createTime;
    protected Date updateTime;
    protected Date createBy;
    protected Date updateBy;
    protected Date isDelete;
    protected Date version;
}
