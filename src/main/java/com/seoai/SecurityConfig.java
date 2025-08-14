package com.seoai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())      // desativa CSRF usando a nova API
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()       // libera todas as requisições
                )
                .httpBasic(Customizer.withDefaults()); // opcional, pode remover se não quiser nem basic auth

        return http.build();
    }
}
