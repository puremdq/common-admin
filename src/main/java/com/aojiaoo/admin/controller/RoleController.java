package com.aojiaoo.admin.controller;
import com.aojiaoo.admin.service.IRoleService;
import com.aojiaoo.admin.entity.Role;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController  {
@Autowired
private IRoleService roleService;

@RequestMapping("")
public ServerResponse
<Page<Role>> list(Page<Role> page, Role role) {
roleService.findPage(page, role);
return ServerResponse.createSuccessWithDta(page);
}

@RequestMapping("form")
public ServerResponse<Role> edit(Role role) {
if (role.getId() != null) {
role = roleService.get(role.getId());
}

return ServerResponse.createSuccessWithDta(role);
}

@RequestMapping("delete")
public ServerResponse delete(Long id) {
this.roleService.delete(id);
return ServerResponse.createSuccess();
}

@RequestMapping("save")
public ServerResponse save(Role role) {
roleService.save(role);
return ServerResponse.createSuccess();
}

}
