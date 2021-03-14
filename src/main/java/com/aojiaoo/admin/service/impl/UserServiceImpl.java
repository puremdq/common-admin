package com.aojiaoo.admin.service.impl;

import com.aojiaoo.admin.service.IUserService;
import com.aojiaoo.admin.entity.User;
    import com.aojiaoo.common.base.BaseService;
    import com.aojiaoo.admin.mapper.UserMapper;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User,UserMapper> implements IUserService{


}
