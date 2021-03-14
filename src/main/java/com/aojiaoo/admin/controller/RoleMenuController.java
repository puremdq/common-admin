package com.aojiaoo.admin.controller;

import com.aojiaoo.admin.entity.RoleMenu;
import com.aojiaoo.admin.service.IRoleMenuService;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Autowired
    private IRoleMenuService roleMenuService;

    @RequestMapping("")
    public ServerResponse
            <Page<RoleMenu>> list(Page<RoleMenu> page, RoleMenu roleMenu) {
        roleMenuService.findPage(page, roleMenu);
        return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<RoleMenu> edit(RoleMenu roleMenu) {
        if (roleMenu.getId() != null) {
            roleMenu = roleMenuService.get(roleMenu.getId());
        }

        return ServerResponse.createSuccessWithDta(roleMenu);
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
        this.roleMenuService.delete(id);
        return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(RoleMenu roleMenu) {
        roleMenuService.save(roleMenu);
        return ServerResponse.createSuccess();
    }

}
