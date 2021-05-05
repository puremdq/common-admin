package com.aojiaoo.admin.config.login;


import com.aojiaoo.admin.permission.LoginInterceptor;
import com.aojiaoo.admin.permission.PermissionProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


/**
 * 登录拦截
 *
 * @author pure
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Resource
    private PermissionProperties permissionProperties;
    @Resource
    private DefaultPermissionHandler defaultPermissionHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册LoginInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor<>(defaultPermissionHandler));
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/favicon.ico",
                "/error",
                permissionProperties.getStaticPath()
        );
    }
}
