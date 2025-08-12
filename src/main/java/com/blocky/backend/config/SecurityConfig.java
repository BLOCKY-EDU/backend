package com.blocky.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())                  // CSRF 비활성화
                .cors(Customizer.withDefaults())               // CORS 활성화
                .formLogin(form -> form.disable())             // 로그인 폼 비활성화
                .httpBasic(basic -> basic.disable())           // HTTP Basic 비활성화
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()                  // 모든 요청 허용
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
