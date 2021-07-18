package com.aojiaoo.admin.config;

import com.aojiaoo.admin.config.properties.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author puremdq
 */
@Configuration
@Slf4j
public class RedisConfig {

    //    @Value("${redis.host}")
//    private String hostName;
//    @Value("${redis.port}")
//    private int port;
//    @Value("${redis.password}")
//    private String passWord;
//    @Value("${redis.maxIdle}")
//    private int maxIdl;
//    @Value("${redis.minIdle}")
//    private int minIdl;
//
//    @Value("${redis.timeout}")
//    private int timeout;
//
//    private static final int DEFAULT_DB = 0;
//
//    @Value("${redis.dbs}")
//    private List<Integer> dbs;
    @Resource
    private RedisProperties redisProperties;

    public static Map<Integer, RedisTemplate<Object, Object>> redisTemplateMap = new HashMap<>();

    @PostConstruct
    public void initRedisTemp() {
        log.info("###### START 初始化 Redis 连接池 START ######");
        for (Integer db : redisProperties.getDbs()) {
            log.info("###### 正在加载Redis-db-" + db + " ######");
            redisTemplateMap.put(db, redisTemplateObject(db));
        }
        log.info("###### END 初始化 Redis 连接池 END ######");
    }


    @Bean("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        return redisConnectionFactory(jedisPoolConfig(), redisProperties.getDefaultDb());
    }


    @Bean("redisTemplate")
    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplateMap.get(redisProperties.getDefaultDb());
    }


    /**
     * jedis连接工厂
     *
     * @param jedisPoolConfig jedisPoolConfig
     * @return RedisConnectionFactory
     */
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig, int db) {
        // 单机版jedis
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        // 设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        // 设置默认使用的数据库
        redisStandaloneConfiguration.setDatabase(db);
        // 设置密码
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassWord()));
        // 设置redis的服务的端口号
        redisStandaloneConfiguration.setPort(redisProperties.getPort());

        // 获得默认的连接池构造器(怎么设计的，为什么不抽象出单独类，供用户使用呢)
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcb = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
                .builder();
        // 指定jedisPoolConifig来修改默认的连接池构造器（真麻烦，滥用设计模式！）
        jpcb.poolConfig(jedisPoolConfig);
        // 通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcb.build();
        // 单机配置 + 客户端配置 = jedis连接工厂
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }


    public RedisTemplate<Object, Object> getRedisTemplateByDb(int db) {
        return redisTemplateMap.get(db);
    }

    /**
     * 连接池配置信息
     *
     * @return JedisPoolConfig
     */
    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxIdle(redisProperties.getMaxIdle());
        // 最小空闲连接数
        poolConfig.setMinIdle(redisProperties.getMinIdle());
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setNumTestsPerEvictionRun(10);
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);
        // 当池内没有可用的连接时，最大等待时间
        poolConfig.setMaxWaitMillis(10000);
        // ------其他属性根据需要自行添加-------------
        return poolConfig;
    }

    private RedisTemplate<Object, Object> redisTemplateObject(Integer dbIndex) {
        RedisTemplate<Object, Object> redisTemplateObject = new RedisTemplate<>();
        redisTemplateObject.setConnectionFactory(redisConnectionFactory(jedisPoolConfig(), dbIndex));
        redisTemplateObject.setKeySerializer(new StringRedisSerializer());
        redisTemplateObject.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplateObject.afterPropertiesSet();
        return redisTemplateObject;
    }

}

