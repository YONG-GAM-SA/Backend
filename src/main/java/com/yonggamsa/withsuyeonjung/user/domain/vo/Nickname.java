package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class Nickname {

    String nickName;

    public static Nickname getNickName(String nickName) {

        return new Nickname(nickName);
    }
}
