package com.aojiaoo.admin.common.enums;

import lombok.Getter;

/**
 * @author puremdq
 */

public enum LogType {

    /**
     * 登录日志
     */
    LOG_IN("login", "登录"),

    /**
     * 登出日志
     */
    LOG_OUT("logout", "登出"),

    /**
     * 业务日志
     */
    BUSINESS("business", "业务日志");

    @Getter
    private final String type;
    @Getter
    private final String desc;

    LogType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }


}
