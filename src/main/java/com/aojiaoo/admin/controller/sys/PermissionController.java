package com.aojiaoo.admin.controller.sys;

import com.aojiaoo.admin.permission.CurrentUser;
import com.aojiaoo.admin.permission.PermissionHolder;
import com.aojiaoo.common.response.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puremdq
 */

@RestController
public class PermissionController {

    @RequestMapping("currentUser")
    public ServerResponse<CurrentUser> currentUser() {
        return ServerResponse.createSuccessWithDta(PermissionHolder.getCurrentUser());
    }
}
