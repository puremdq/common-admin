package com.aojiaoo.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;

/**
 * @author puremdq
 */
@Configuration
@EnableSpringHttpSession
public class SpringHttpSessionConfig {

    private static final int SESSION_REDIS_DB = 15;

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public SessionRepository sessionRepository() {
        RedisIndexedSessionRepository redisIndexedSessionRepository = new RedisIndexedSessionRepository(getSessionRedisTemplate());
        redisIndexedSessionRepository.setDatabase(10);
        return redisIndexedSessionRepository;
    }

    private RedisTemplate<Object, Object> getSessionRedisTemplate() {
        return redisConfig.getRedisTemplateByDb(SESSION_REDIS_DB);
    }

}

