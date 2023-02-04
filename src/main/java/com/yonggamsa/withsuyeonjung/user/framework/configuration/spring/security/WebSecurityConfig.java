package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security;

import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.YamlPropertySourceFactory;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.exception.RestAuthenticationEntryPoint;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.filter.JwtAuthenticationFilter;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.handler.OAuth2AuthenticationFailureHandler;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.handler.OAuth2AuthenticationSuccessHandler;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.handler.TokenAccessDeniedHandler;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.provider.JwtProvider;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.repository.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.repository.RefreshTokenRepository;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.service.CustomOAuth2UserService;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.vo.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@PropertySource(value = "classpath:application-oauth.yml", factory = YamlPropertySourceFactory.class)
public class WebSecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtProvider jwtProvider;
    private final AppProperties appProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenAccessDeniedHandler tokenAccessDeniedHandler;

    @Autowired
    private Environment env;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter(jwtProvider);
    }

    @Bean
    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository(){
        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
    }

    @Bean
    public OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler(){
        return new OAuth2AuthenticationSuccessHandler(
                jwtProvider,
                appProperties,
                refreshTokenRepository,
                oAuth2AuthorizationRequestBasedOnCookieRepository()
        );
    }

    @Bean
    public OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler(){
        return new OAuth2AuthenticationFailureHandler(oAuth2AuthorizationRequestBasedOnCookieRepository());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                    .headers().frameOptions().sameOrigin()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .csrf().disable()
                    .httpBasic().disable()
                    .formLogin().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                    .accessDeniedHandler(tokenAccessDeniedHandler)
                .and()
                    .authorizeRequests()
                    .antMatchers("/h2-console/**","favicon.ico").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .oauth2Login()
                    .authorizationEndpoint()
                    .baseUri("/oauth2/authorization")
                    .authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository())
                .and()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService)
                .and()
                    .successHandler(oAuth2AuthenticationSuccessHandler())
                    .failureHandler(oAuth2AuthenticationFailureHandler());

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
