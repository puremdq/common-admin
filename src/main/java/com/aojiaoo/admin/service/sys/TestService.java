package com.aojiaoo.admin.service.sys;

import com.aojiaoo.admin.entity.sys.User;
import org.springframework.cache.annotation.Cacheable;

public interface TestService {
    User getUser();
}
