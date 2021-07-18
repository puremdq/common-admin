package com.aojiaoo.admin.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author puremdq
 */
public class CacheUtil {



    private static final Map<String, CacheManager> CACHE_MANAGER_MAP = new HashMap<>();
    private static String defaultCacheManagerName = "";


    public static void put(String cacheName, Object key, Object value) {
        if (value == null) {
            return;
        }
        getCache(cacheName).put(key, value);
    }

    public static Object get(String cacheName, Object key) {
        return getCache(cacheName).get(key);
    }

    public static <T> T get(String cacheName, Object key, @Nullable Class<T> tClass) {
        return getCache(cacheName).get(key, tClass);
    }

    public static Cache getCache(String cacheName) {
        return getDefaultCacheManager().getCache(cacheName);
    }

    public static CacheManager getDefaultCacheManager() {
        return CACHE_MANAGER_MAP.get(defaultCacheManagerName);
    }


}
