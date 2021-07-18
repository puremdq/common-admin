package com.aojiaoo.admin.config;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author puremdq
 */
@Configuration
public class CacheConfig {

    @Bean("redisCacheManager")
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        //缓存配置对象
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration
                //设置缓存的默认超时时间：30分钟
//                .entryTtl(Duration.ofMinutes(30L))
                //如果是空值，不缓存
                .disableCachingNullValues()
                //设置key序列化器
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                //设置value序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer((new GenericJackson2JsonRedisSerializer())));


        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }


    @Primary
    @Bean("ehcacheManager")
    public CacheManager ehcacheManager() throws FileNotFoundException, URISyntaxException {
        return new JCacheCacheManager(jCacheManager());
    }

    private javax.cache.CacheManager jCacheManager() throws FileNotFoundException, URISyntaxException {

        //ehcache实现了javax的CachingProvider接口的具体实现
        EhcacheCachingProvider ehcacheCachingProvider = new EhcacheCachingProvider();
        //根据配置文件获取CacheManager
        URI uri = ResourceUtils.getURL("classpath:ehcache.xml").toURI();

        return ehcacheCachingProvider.getCacheManager(uri, this.getClass().getClassLoader());
    }

//    public javax.cache.configuration.Configuration build() {
//
//        return Eh107Configuration.fromEhcacheCacheConfiguration(CacheConfigurationBuilder
//                .newCacheConfigurationBuilder(String.class, Object.class,
//                        ResourcePoolsBuilder.heap(10))
//                .withExpiry(
//                        ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(3600)))
//                .build());
//
//    }


}
