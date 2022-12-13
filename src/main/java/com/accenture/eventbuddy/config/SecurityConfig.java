package com.accenture.eventbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .headers().frameOptions().disable().and()
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll() // TODO: REMOVE
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/**").authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/event/eventList", true).and()
                .build();
    }

}
