package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.*;

@Getter
@NoArgsConstructor
public class Nickname {

    private String nickname;

    @Builder
    public Nickname(String nickname) {
        this.nickname = nickname;
    }
}
