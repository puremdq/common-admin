package com.aojiaoo.admin.service;

import com.aojiaoo.admin.config.permission.CurrentUser;
import com.aojiaoo.admin.config.permission.PermissionHolder;
import com.aojiaoo.admin.entity.sys.User;
import com.aojiaoo.common.base.BaseEntity;
import com.aojiaoo.common.constant.ConstProperties;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author puremdq
 */
public abstract class BaseService<E extends BaseEntity<E>, M extends BaseMapper<E>> extends com.aojiaoo.common.base.BaseService<E, M> {


    @Override
    public String getCurrentUser() {
        CurrentUser currentUser = PermissionHolder.getCurrentUser();
        return currentUser == null ? ConstProperties.SYSTEM_USER : currentUser.getUsername();
    }

}
