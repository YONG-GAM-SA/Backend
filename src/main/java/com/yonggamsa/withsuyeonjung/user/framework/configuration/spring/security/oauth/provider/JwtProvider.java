package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.provider;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.token.AuthToken;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JwtProvider {

    private final Key key;
    private static final String AUTHORITES_KEY = "role";

    public AuthToken convertAuthToken(String token){
        return new AuthToken(key, token);
    }

    public Authentication getAuthentication(AuthToken authToken){

        if(authToken.validate()){

            Claims claims = authToken.getTokenClaims();
            Collection<? extends GrantedAuthority> authorities =
                    Arrays.stream(new String[]{claims.get(AUTHORITES_KEY).toString()})
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

            User principal = new User(claims.getSubject(), "", authorities);

            return new UsernamePasswordAuthenticationToken(principal, authToken, authorities);
        } else {
          throw new IllegalArgumentException("JWT invalidate failed");
        }

    }

}
