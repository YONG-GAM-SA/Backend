package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class Password {

    String password;

    public static Password getPassword(String password) {

        return new Password(password);
    }
}
