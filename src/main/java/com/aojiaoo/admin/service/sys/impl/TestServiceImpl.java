package com.aojiaoo.admin.service.sys.impl;

import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.admin.entity.sys.UserRole;
import com.aojiaoo.admin.mapper.sys.UserMapper;
import com.aojiaoo.admin.service.BaseService;
import com.aojiaoo.admin.service.sys.TestService;
import com.aojiaoo.admin.service.sys.UserRoleService;
import com.aojiaoo.admin.service.sys.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
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
public class TestServiceImpl extends BaseService<User, UserMapper> implements TestService {

    @Resource
    private UserRoleService userRoleService;

    @Override
    @Cacheable(cacheManager = "ehcache",cacheNames = "usr")
    public User getUser() {
        System.out.println("sdf");
        return new User();
    }


}
