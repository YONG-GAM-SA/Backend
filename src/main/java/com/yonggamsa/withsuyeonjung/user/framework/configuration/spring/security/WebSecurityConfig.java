package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.YamlPropertySourceFactory;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.auth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
                .authorizeRequests()
                .antMatchers("/h2-console/**","favicon.ico").permitAll()
                .anyRequest().authenticated()
                    .and()
                .oauth2Login()
                .userInfoEndpoint().userService(customOAuth2UserService);

        return http.build();
    }
}
