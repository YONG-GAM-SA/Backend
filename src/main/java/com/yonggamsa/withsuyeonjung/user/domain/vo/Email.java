package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class Email {

    private String email;
    public static Email getEmail(String email) {
        return new Email(email);
    }
}
