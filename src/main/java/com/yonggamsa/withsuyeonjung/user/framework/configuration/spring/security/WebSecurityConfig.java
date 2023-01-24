package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.YamlPropertySourceFactory;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@PropertySource(value = "classpath:application-oauth.yml", factory = YamlPropertySourceFactory.class)
public class WebSecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    @Autowired
    private Environment env;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .headers().frameOptions().sameOrigin()
                    .and()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                    .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**","favicon.ico").permitAll()
                .anyRequest().authenticated()
                    .and()
                .oauth2Login()
                .userInfoEndpoint().userService(customOAuth2UserService);

        return http.build();
    }
}
