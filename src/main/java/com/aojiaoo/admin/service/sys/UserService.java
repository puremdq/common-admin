package com.aojiaoo.admin.service.sys;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.entity.sys.UserRole;
import com.aojiaoo.admin.mapper.sys.UserMapper;
import com.aojiaoo.common.base.IService;

import java.util.List;

/**
 * @author pure
 */
public interface UserService extends IService<User, UserMapper> {

    /**
     * 检查用户名密码是否正确
     *
     * @param userName userName
     * @param password password
     * @return 用户名密码是否正确
     */
    boolean check(String userName, String password);


    /**
     * 得到角色ID列表
     *
     * @param userName 用户名
     * @return 角色ID列表
     */
    List<UserRole> getRoleList(String userName);
}
