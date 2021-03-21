package com.aojiaoo.admin.service;

import com.aojiaoo.common.base.BaseEntity;
import com.aojiaoo.common.constant.ConstProperties;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author puremdq
 */
public class BaseService<E extends BaseEntity<E>, M extends BaseMapper<E>> extends com.aojiaoo.common.base.BaseService<E, M> {
    @Override
    public String getCurrentUser() {
        return ConstProperties.SYSTEM_USER;
    }
}
