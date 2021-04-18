package com.aojiaoo.admin.permission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pure
 */
public interface PermissionHandler {

    /**
     * 登录
     *
     * @param request  request
     * @param response response
     */
    void login(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 登出
     *
     * @param request  request
     * @param response response
     */
    void logout(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 获取当前用户
     *
     * @param request 请求
     * @return 当前用葫芦
     */
    CurrentUser getCurrentUser(HttpServletRequest request);


    /**
     * 当前用户是否登录
     *
     * @param request 请求
     * @return 当前用葫芦
     */
    default boolean isLogin(HttpServletRequest request) {
        return getCurrentUser(request) != null;
    }


}
