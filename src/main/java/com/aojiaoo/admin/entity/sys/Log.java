package com.aojiaoo.admin.entity.sys;

import com.aojiaoo.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_log")
public class Log extends BaseEntity<Log> {

    private static final long serialVersionUID = 1L;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }


    /**
     * ip
     * 表字段： sys_log.ip
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * http请求方式
     * 表字段： sys_log.http_method
     */
    @TableField(value = "http_method")
    private String httpMethod;

    /**
     * 请求参数
     * 表字段： sys_log.params
     */
    @TableField(value = "params")
    private String params;

    /**
     * 返回结果
     * 表字段： sys_log.result
     */
    @TableField(value = "result")
    private String result;
    /**
     * 时间消耗
     * 表字段： sys_log.time_cost
     */
    @TableField(value = "time_cost")
    private Long timeCost;

}
