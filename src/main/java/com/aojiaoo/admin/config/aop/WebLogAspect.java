package com.aojiaoo.admin.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class WebLogAspect {


    //签名，可以理解成这个切入点的一个名称
    @Pointcut("execution(public * com.aojiaoo.admin.controller.*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerCut() {
    }

    //在切入点的方法run之前要干的
    @Before("controllerCut()")
    public void beforeController(JoinPoint joinPoint) {


        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        log.info("################URL : " + request.getRequestURL().toString());
        log.info("################HTTP_METHOD : " + request.getMethod());
        log.info("################IP : " + request.getRemoteAddr());
        log.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        log.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //log.info("################TARGET: " + joinPoint.getTarget(\
        // ));//返回的是需要加强的目标类的对象
        //log.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }


    @AfterReturning(value = "controllerCut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("1、AfterReturning");
    }

}
