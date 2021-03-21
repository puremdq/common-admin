package com.aojiaoo.admin.controller.sys;

import com.aojiaoo.admin.entity.sys.Menu;
import com.aojiaoo.admin.service.sys.MenuService;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("")
    public ServerResponse
            <Page<Menu>> list(Page<Menu> page, Menu menu) {
        menuService.findPage(page, menu);
        return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<Menu> edit(Menu menu) {
        if (menu.getId() != null) {
            menu = menuService.get(menu.getId());
        }

        return ServerResponse.createSuccessWithDta(menu);
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
        this.menuService.delete(id);
        return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(Menu menu) {
        menuService.save(menu);
        return ServerResponse.createSuccess();
    }

}
