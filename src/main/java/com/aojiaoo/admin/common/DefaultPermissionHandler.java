package com.aojiaoo.admin.common;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.exception.CommonAdminException;
import com.aojiaoo.admin.permission.CurrentUser;
import com.aojiaoo.admin.permission.PermissionHandler;
import com.aojiaoo.admin.service.sys.UserService;
import com.aojiaoo.common.response.ServerResponse;
import com.aojiaoo.common.utils.JsonUtil;
import com.aojiaoo.common.utils.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pure
 */
@Component
public class DefaultPermissionHandler implements PermissionHandler {

    @Resource
    private UserService userService;

    private static final String CURRENT_USER_SESSION_KEY = "current_user_session";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter(USERNAME_KEY);
        String password = request.getParameter(PASSWORD_KEY);
        if (StringUtils.isBlank(userName)) {
            throw new CommonAdminException(ResponseMsg.ILLEGAL_ARGUMENT);
        }
        boolean check = userService.check(userName, password);
        if (!check) {
            throw new CommonAdminException(ResponseMsg.ILLEGAL_PASSWORD);
        }
        User user = userService.get(User.builder().userName(userName).build());
        CurrentUser currentUser = CurrentUser.builder().username(user.getUserName()).realName(user.getName()).build();
        request.getSession().setAttribute(CURRENT_USER_SESSION_KEY, currentUser);
        WebUtils.writeBody(response.getWriter(), JsonUtil.toJsonString(ServerResponse.createSuccess()));
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(CURRENT_USER_SESSION_KEY);
        WebUtils.writeBody(response.getWriter(), JsonUtil.toJsonString(ServerResponse.createSuccess()));
    }

    @Override
    public CurrentUser getCurrentUser(HttpServletRequest request) {
        return (CurrentUser) request.getSession().getAttribute(CURRENT_USER_SESSION_KEY);
    }


}
