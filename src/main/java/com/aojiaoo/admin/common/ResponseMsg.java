package com.aojiaoo.admin.common;

import com.aojiaoo.common.response.CommonResponseMsg;

/**
 * @author pure
 */
public class ResponseMsg extends CommonResponseMsg {

    public static final CommonResponseMsg ILLEGAL_PASSWORD = new ResponseMsg(4001, 401, "ILLEGAL_PASSWORD");


    private ResponseMsg(int code, int httpCode, String msg) {
        super(code, httpCode, msg);
    }
}
