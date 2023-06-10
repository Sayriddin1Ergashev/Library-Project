package com.company.LibraryProject.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfiguration {
   /* @Bean
    public PasswordEncoder encoder() {
        return new BCruptPasswordEncoder();
    }*/

    @PostConstruct
    public void init() {
        System.out.println("This init method execute!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("This destroy method execute!");
    }
}
