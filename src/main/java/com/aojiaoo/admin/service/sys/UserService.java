package com.aojiaoo.admin.service.sys;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.mapper.sys.UserMapper;
import com.aojiaoo.common.base.IService;

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
}
