package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@PropertySource("classpath:application-oauth.yml")
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/h2-console/**","favicon.ico").permitAll()
                .anyRequest().authenticated()
                    .and()
                .oauth2Login();

        return http.build();
    }

}
