package com.aojiaoo.admin.service.sys;

import com.aojiaoo.admin.common.enums.LogType;
import com.aojiaoo.admin.entity.sys.Log;
import com.aojiaoo.admin.mapper.sys.LogMapper;
import com.aojiaoo.common.base.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puremdq
 */
public interface LogService extends IService<Log, LogMapper> {

    /**
     * 写入日志
     *
     * @param request  request请求
     * @param result   结果
     * @param timeCost 时间消耗
     */
    void insertLog(HttpServletRequest request, LogType logType, Object result, long timeCost);

}
