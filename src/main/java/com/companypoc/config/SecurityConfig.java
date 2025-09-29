//package com.companypoc.config;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.context.annotation.Bean;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())   // disable CSRF for testing
//                .authorizeHttpRequests(auth -> auth
//                                .anyRequest().permitAll() // allow all requests without login
//                );
//        return http.build();
//    }
//}
