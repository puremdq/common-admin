package com.aojiaoo.admin.exception;


import com.aojiaoo.common.response.CommonResponseMsg;

/**
 * CommonAdmin 常规异常
 *
 * @author pure
 */
public class CommonAdminException extends RuntimeException {

    protected CommonResponseMsg responseMsg;

    public CommonAdminException(CommonResponseMsg responseMsg) {
        this.responseMsg = responseMsg;
    }

    public CommonAdminException(CommonResponseMsg responseMsg, String msg) {
        super(msg);
        this.responseMsg = responseMsg;
    }

    public CommonResponseMsg getResponseMsg() {
        return responseMsg;
    }

}
