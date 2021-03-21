package com.aojiaoo.admin.service.sys.impl;

import com.aojiaoo.admin.entity.sys.Log;
import com.aojiaoo.admin.mapper.sys.LogMapper;
import com.aojiaoo.admin.service.BaseService;
import com.aojiaoo.admin.service.sys.LogService;
import com.aojiaoo.common.utils.JsonUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puremdq
 */
@Service
public class LogServiceImpl extends BaseService<Log, LogMapper> implements LogService {


    @Async
    @Override
    public void insertLog(HttpServletRequest request, Object[] args, Object result, long timeCost) {
        Log sysLog = new Log();
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setHttpMethod(request.getRemoteAddr());
        sysLog.setParams(JsonUtil.toJsonString(request.getParameterMap()));
        sysLog.setResult(JsonUtil.toJsonString(result));
        sysLog.setTimeCost(timeCost);
        this.insert(sysLog);
    }



}
