package com.aojiaoo.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

import java.util.HashMap;

@Configuration
@EnableSpringHttpSession
public class SpringHttpSessionConfig {
    @Bean
    public SessionRepository sessionRepository() {
        return new MapSessionRepository(new HashMap<>());
    }
}

