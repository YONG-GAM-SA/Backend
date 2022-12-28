package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class Token {

    String token;

    public static Token getToken(String token) {
        return new Token(token);
    }
}
