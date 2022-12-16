package com.kimseolhan.coffeeordersystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/join", "/client/**").permitAll()
                // admin 페이지는 ADMIN 권한만 접근 가능
                .requestMatchers("/admin").hasRole("ADMIN")
        )
        // 폼 로그인
        .formLogin();
        return http.build();
    }
}
