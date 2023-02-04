package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.provider;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.token.AuthToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtProvider {

    private final Key key;
    private static final String AUTHORITES_KEY = "role";

    public JwtProvider(String secret){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public AuthToken createAuthToken(String id, Date expiry){
        return new AuthToken(id, expiry, key);
    }

    public AuthToken createAuthToken(String id, String role, Date expiry){
        return new AuthToken(id, role, expiry, key);
    }

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
