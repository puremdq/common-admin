package com.aojiaoo.admin.config.permission;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截
 *
 * @param <T> T extends PermissionHandle 权限处理类
 * @author pure
 */
public class LoginInterceptor<T extends PermissionHandler> implements HandlerInterceptor {

    private final PermissionHandler permissionHandler;

    public LoginInterceptor(T permissionHandler) {
        this.permissionHandler = permissionHandler;
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
     * //如果设置为true时，请求将会继续执行后面的操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        return true;

//        PermissionProperties permissionProperties = SpringContextUtil.getBean(PermissionProperties.class);
//
//        String uri = request.getRequestURI();
//
//        if (uri.equals(permissionProperties.getLoginPath())) {
//            permissionHandler.login(request, response);
//            return false;
//        }
//
//        if (uri.equals(permissionProperties.getLogoutPath())) {
//            permissionHandler.logout(request, response);
//            return false;
//        }
//
//        CurrentUser currentUser = permissionHandler.getCurrentUser(request);
//        if (currentUser != null) {
//            PermissionHolder.setCurrentUser(currentUser);
//            return true;
//        }
//
//        throw new CommonAdminException(CommonResponseMsg.NEED_LOGIN);
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

}
