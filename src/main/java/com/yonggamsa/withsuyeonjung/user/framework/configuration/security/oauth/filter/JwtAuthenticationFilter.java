package com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.filter;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.provider.JwtProvider;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.token.AuthToken;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.utils.HeaderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenStr = HeaderUtil.getAccessToken(request);
        AuthToken token = jwtProvider.convertAuthToken(tokenStr);

        if(token.validate()){
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }



}