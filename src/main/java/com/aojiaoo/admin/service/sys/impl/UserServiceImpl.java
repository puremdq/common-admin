package com.aojiaoo.admin.service.sys.impl;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.entity.sys.UserRole;
import com.aojiaoo.admin.mapper.sys.UserMapper;
import com.aojiaoo.admin.service.BaseService;
import com.aojiaoo.admin.service.sys.UserRoleService;
import com.aojiaoo.admin.service.sys.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author puremdq
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseService<User, UserMapper> implements UserService {

    @Resource
    private UserRoleService userRoleService;

    @Override
    public boolean check(String userName, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(User.builder().userName(userName).build());
        User user = this.getMapper().selectOne(queryWrapper);
        if (user == null) {
            log.debug("userName:[{}]不存在", userName);
            return false;
        }
        String s = DigestUtils.md5DigestAsHex((user.getSalt() + password).getBytes(StandardCharsets.UTF_8));
        return s.equals(user.getPassword());
    }

    @Override
    public List<UserRole> getRoleList(String userName) {
        return userRoleService.findList(UserRole.builder().userName(userName).build());
    }


}
