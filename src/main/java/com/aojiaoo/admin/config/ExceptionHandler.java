package com.aojiaoo.admin.config;

import com.aojiaoo.admin.exception.CommonAdminException;
import com.aojiaoo.common.response.CommonResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pure
 */
@Slf4j
@Configuration
public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        log.error("error",ex);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (ex instanceof CommonAdminException) {
            CommonResponseMsg responseMsg = ((CommonAdminException) ex).getResponseMsg();
            modelAndView.setStatus(HttpStatus.valueOf(responseMsg.getHttpCode()));
            modelAndView.addObject("code", responseMsg.getCode());
            modelAndView.addObject("msg", responseMsg.getMsg());
        } else {
            modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            modelAndView.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            modelAndView.addObject("msg", ex.getMessage());
        }
        return modelAndView;
    }
}
