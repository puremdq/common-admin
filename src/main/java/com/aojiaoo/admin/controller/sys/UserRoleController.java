package com.aojiaoo.admin.controller.sys;

import com.aojiaoo.admin.service.sys.UserRoleService;
import com.aojiaoo.admin.entity.sys.UserRole;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("")
    public ServerResponse
            <Page<UserRole>> list(Page<UserRole> page, UserRole userRole) {
        userRoleService.findPage(page, userRole);
        return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<UserRole> edit(UserRole userRole) {
        if (userRole.getId() != null) {
            userRole = userRoleService.get(userRole.getId());
        }

        return ServerResponse.createSuccessWithDta(userRole);
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
        this.userRoleService.delete(id);
        return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(UserRole userRole) {
        userRoleService.save(userRole);
        return ServerResponse.createSuccess();
    }

}
