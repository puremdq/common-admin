package com.aojiaoo.admin.common;

import com.aojiaoo.admin.common.enums.LogType;
import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.exception.CommonAdminException;
import com.aojiaoo.admin.permission.CurrentUser;
import com.aojiaoo.admin.permission.PermissionHandler;
import com.aojiaoo.admin.service.sys.LogService;
import com.aojiaoo.admin.service.sys.UserService;
import com.aojiaoo.common.response.ServerResponse;
import com.aojiaoo.common.utils.DateUtils;
import com.aojiaoo.common.utils.JsonUtil;
import com.aojiaoo.common.utils.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author pure
 */
@Component
public class DefaultPermissionHandler implements PermissionHandler {

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    private static final String CURRENT_USER_SESSION_KEY = "current_user_session";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = System.currentTimeMillis();

        String userName = request.getParameter(USERNAME_KEY);
        String password = request.getParameter(PASSWORD_KEY);
        if (StringUtils.isBlank(userName)) {
            throw new CommonAdminException(ResponseMsg.ILLEGAL_ARGUMENT);
        }
        boolean check = userService.check(userName, password);
        if (!check) {
            recordLoginLog(request, LogType.LOG_IN, userName, false, startTime);
            throw new CommonAdminException(ResponseMsg.ILLEGAL_PASSWORD);
        }
        User user = userService.get(User.builder().userName(userName).build());
        CurrentUser currentUser = CurrentUser.builder().username(user.getUserName()).realName(user.getName()).build();
        request.getSession().setAttribute(CURRENT_USER_SESSION_KEY, currentUser);
        recordLoginLog(request, LogType.LOG_IN, userName, true, startTime);

        WebUtils.writeBody(response.getWriter(), JsonUtil.toJsonString(ServerResponse.createSuccess()));
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long startTime = System.currentTimeMillis();
        CurrentUser currentUser = getCurrentUser(request);

        request.getSession().removeAttribute(CURRENT_USER_SESSION_KEY);
        recordLoginLog(request, LogType.LOG_OUT, currentUser == null ? "" : currentUser.getUsername(), true, startTime);
        WebUtils.writeBody(response.getWriter(), JsonUtil.toJsonString(ServerResponse.createSuccess()));
    }

    @Override
    public CurrentUser getCurrentUser(HttpServletRequest request) {
        return (CurrentUser) request.getSession().getAttribute(CURRENT_USER_SESSION_KEY);
    }

    private void recordLoginLog(HttpServletRequest request, LogType logType, String currentUserName, boolean isSuccess, long startTime) {
        //用户 xx 于 2020-12-01 23:59:59 登录 false
        String msg = "用户[{0}]于[{1}][{2}][{3}]";
        msg = MessageFormat.format(msg, currentUserName, DateUtils.getDateTime(), logType.getDesc(), isSuccess);
        logService.insertLog(request, logType, msg, System.currentTimeMillis() - startTime);
    }

}
