package com.aojiaoo.admin.service;

import com.aojiaoo.admin.permission.CurrentUser;
import com.aojiaoo.admin.permission.PermissionUtil;
import com.aojiaoo.common.base.BaseEntity;
import com.aojiaoo.common.constant.ConstProperties;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author puremdq
 */
public class BaseService<E extends BaseEntity<E>, M extends BaseMapper<E>> extends com.aojiaoo.common.base.BaseService<E, M> {


    @Override
    public String getCurrentUser() {
        CurrentUser currentUser = PermissionUtil.getCurrentUser();
        return currentUser == null ? ConstProperties.SYSTEM_USER : currentUser.getUsername();
    }
}
