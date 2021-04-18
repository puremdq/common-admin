package com.aojiaoo.admin.config;

import com.aojiaoo.admin.common.enums.LogType;
import com.aojiaoo.admin.service.sys.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puremdq
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {


    @Autowired
    private LogService logService;


    /**
     * 签名，可以理解成这个切入点的一个名称
     */
    @Pointcut("execution(public * com.aojiaoo.admin.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerCut() {
    }


    @Around("controllerCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = null;
        if (requestAttributes instanceof ServletRequestAttributes) {
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        Object[] args = point.getArgs();
        Object result = null;
        try {
            result = point.proceed(args);
            return result;
        } catch (Throwable e) {
            result = e.toString();
            throw e;
        } finally {
            if (request != null) {
                logService.insertLog(request, LogType.BUSINESS, result, System.currentTimeMillis() - start);
            } else {
                log.error("遇到未知的情况，当前请求为空");
            }
        }
    }

}
