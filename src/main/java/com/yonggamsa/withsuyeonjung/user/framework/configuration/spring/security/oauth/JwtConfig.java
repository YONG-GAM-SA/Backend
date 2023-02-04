package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.provider.JwtProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtProvider jwtProvider(){
        return new JwtProvider(secret);
    }
}
