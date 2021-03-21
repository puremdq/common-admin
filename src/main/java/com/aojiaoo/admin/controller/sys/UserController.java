package com.aojiaoo.admin.controller.sys;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.service.sys.UserService;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ServerResponse
            <Page<User>> list(Page<User> page, User user) {
        userService.findPage(page, user);
        return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<User> edit(User user) {
        if (user.getId() != null) {
            user = userService.get(user.getId());
        }

        return ServerResponse.createSuccessWithDta(user);
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
        this.userService.delete(id);
        return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(User user) {
        userService.save(user);
        return ServerResponse.createSuccess();
    }

}
