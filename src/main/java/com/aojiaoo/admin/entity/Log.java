package com.aojiaoo.admin.entity;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("log")
public class Log extends BaseEntity<Log> {

    private static final long serialVersionUID = 1L;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }

    /**
     * ip
     * 表字段： log.ip
     */
    @TableField(value = "ip")
    private String ip;
    /**
     * 请求
     * 表字段： log.request
     */
    @TableField(value = "request")
    private String request;
    /**
     * 参数
     * 表字段： log.params
     */
    @TableField(value = "params")
    private String params;
    /**
     * 返回结果
     * 表字段： log.result
     */
    @TableField(value = "result")
    private String result;
    /**
     * 时间消耗
     * 表字段： log.time_cost
     */
    @TableField(value = "time_cost")
    private Integer timeCost;

}
