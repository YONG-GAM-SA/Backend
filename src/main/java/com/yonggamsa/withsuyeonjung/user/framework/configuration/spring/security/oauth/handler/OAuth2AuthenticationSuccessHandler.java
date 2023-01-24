package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.handler;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.provider.JwtProvider;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.repository.RefreshTokenRepository;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.utils.CookieUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private static final String REDIRECT_URI_PARAM_COOKIE_NAME = "/";

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        String targetUrl = determineTargetUrl(request, response, authentication);
//
//        if(response.isCommitted()){
//            log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
//            return;
//        }
//
//        clearAuthenticationAttributes(request);
//        getRedirectStrategy().sendRedirect(request, response, targetUrl);
//    }
//
//    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
//        Optional<String> redirectUri = CookieUtil.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME).map(Cookie::getValue);
//
//        if(redirectUri.isPresent() && isAuthorizedRedirectUri(redirectUri.get())){
//            throw new IllegalArgumentException("We've got an Unauthorized Redirect URI and can't proceed with the authentication");
//        }
//
//        re
//
//    }

    private boolean isAuthorizedRedirectUri(String uri){
        URI clientRedirectUri = URI.create(uri);

//        구현 해야 함.

        return true;
    }

}
