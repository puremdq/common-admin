package com.aojiaoo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author puremdq
 */
@EnableAsync
@SpringBootApplication
public class CommonAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonAdminApplication.class, args);
    }

}
