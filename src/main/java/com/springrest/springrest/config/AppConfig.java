package com.springrest.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.springrest.sprinrgest.services.CourseService;
import com.springrest.sprinrgest.services.CourseServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    CourseService courseService() {
        return new CourseServiceImpl();
    }
}
