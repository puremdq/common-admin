package com.aojiaoo.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author puremdq
 */
@Configuration
public class LoginFilterConfig {

    @Value("${login.loginPath}")
    private String loginPath;
    @Value("${login.logoutPath}")
    private String logoutPath;

    @Bean
    public FilterRegistrationBean<LoginFilter> filterRegistration() {
        // 新建过滤器注册类
        FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
        // 添加自定义 过滤器
        registration.setFilter(new LoginFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        //设置过滤器顺序
        registration.setOrder(1);
        return registration;
    }

    final class LoginFilter implements Filter {

        @Override
        public void init(javax.servlet.FilterConfig filterConfig) {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                String requestURI = httpServletRequest.getRequestURI();
                if (requestURI.equals(loginPath)) {
                    System.out.println("login path");
                }

            }
            System.out.println("first filter 1");
            chain.doFilter(request, response);
            System.out.println("first filter 2");
        }

        @Override
        public void destroy() {

        }
    }
}
