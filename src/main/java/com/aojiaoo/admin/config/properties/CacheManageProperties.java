package com.aojiaoo.admin.config.properties;

/**
 * @author puremdq
 */

public interface CacheManageProperties {

    String REDIS_CACHE_MANAGER = "redisCacheManager";

    /**
     * ehCache
     */
    String EHCACHE_CACHE_MANAGER = "ehCacheCacheManager";
    String DEFAULT_CACHE_MANAGER = "redisCacheManager";

}
