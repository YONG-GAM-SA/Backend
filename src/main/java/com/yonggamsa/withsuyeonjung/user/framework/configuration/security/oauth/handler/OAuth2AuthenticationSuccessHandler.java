package com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.handler;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.data.RefreshToken;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.RefreshTokenRepository;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.provider.JwtProvider;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.repository.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.token.AuthToken;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.utils.CookieUtil;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.vo.AppProperties;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.vo.OAuthAttributes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;
    private final AppProperties appProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response, authentication);

        if(response.isCommitted()){
            log.debug("응답이 이미 처리됐습니다. 해당 Url로 리다이렉트할 수 없습니다. :: " + targetUrl);
            return;
        }

        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }



    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUrl = CookieUtil.getCookie(request, OAuth2AuthorizationRequestBasedOnCookieRepository.REDIRECT_URI_NAME_COOKIE_NAME)
                .map(Cookie::getValue);

        if (redirectUrl.isPresent() && !isAuthorizedRedirectUri(redirectUrl.get())) {
            throw new IllegalArgumentException("인가되지 않은 리다이렉트 주소를 받아서 인증을 진행할 수 없습니다.");
        }

        String targetUrl = redirectUrl.orElse(getDefaultTargetUrl()); // default : "/"
        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User principal = (OAuth2User) authentication.getPrincipal();

        OAuthAttributes oAuthAttributes = OAuthAttributes.of(principal.getName(), principal.getAttributes());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Date now = new Date();
        AuthToken accessToken = jwtProvider.createAuthToken(
                oAuthAttributes.getNameAttributeKey(),
                new Date(now.getTime() + appProperties.getAuth().getTokenExpiry())
        );

        long refreshTokenExpiry = appProperties.getAuth().getRefreshTokenExpiry();
        AuthToken refreshToken = jwtProvider.createAuthToken(
                appProperties.getAuth().getTokenSecret(),
                new Date(now.getTime() + refreshTokenExpiry)
        );

        RefreshToken userRefreshToken = refreshTokenRepository.findByUserId(oAuthAttributes.getId());
        if (userRefreshToken != null) {
            userRefreshToken.setRefreshToken(refreshToken.getToken());
        } else {
            userRefreshToken = new RefreshToken(oAuthAttributes.getId(), refreshToken.getToken());
            refreshTokenRepository.save(userRefreshToken);
        }

        int cookieMaxAge = (int) refreshTokenExpiry / 60;

        CookieUtil.deleteCookie(request, response, OAuth2AuthorizationRequestBasedOnCookieRepository.REFRESH_TOKEN);
        CookieUtil.addCookie(response, OAuth2AuthorizationRequestBasedOnCookieRepository.REFRESH_TOKEN, refreshToken.getToken(), cookieMaxAge);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", accessToken.getToken())
                .build().toUriString();
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);
        return appProperties.getOAuth2().getAuthorizedRedirectUris()
                .stream()
                .anyMatch(authorizedRedirectUri -> {
                    URI authorizedURI = URI.create(authorizedRedirectUri);
                    if(authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                        && authorizedURI.getPort() == clientRedirectUri.getPort()){
                        return true;
                    }
                    return false;
                });
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response){
        super.clearAuthenticationAttributes(request);
        authorizationRequestRepository.removeAuthorizationRequest(request, response);
    }

    private boolean hasAuthority(Collection<? extends GrantedAuthority> authorities, String authority){
        if(authority == null) return false;

        return authorities.stream().anyMatch(auth -> authority.equals(auth.getAuthority()));
    }
}
