package com.aojiaoo.admin.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author puremdq
 */
@Data
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host;
    private int port;
    private String passWord;
    private int maxIdle;
    private int minIdle;
    private int timeout;
    private int defaultDb = 0;
    private List<Integer> dbs;
}
