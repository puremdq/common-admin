package com.aojiaoo.admin.permission;

import com.aojiaoo.admin.util.SpringContextUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pure
 */
public class PermissionUtil {

    public static CurrentUser getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return SpringContextUtil.getBean(PermissionHandler.class).getCurrentUser(request);
    }
}
