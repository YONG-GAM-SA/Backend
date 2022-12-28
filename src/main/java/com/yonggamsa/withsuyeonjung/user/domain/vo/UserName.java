package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class UserName {

    String userName;

    public static UserName getUserName(String userName) {
        return new UserName(userName);
    }
}
