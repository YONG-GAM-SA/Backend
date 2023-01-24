package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.*;

@Getter
@NoArgsConstructor
public class UserName {

    private String userName;

    @Builder
    public UserName(String userName) {
        this.userName = userName;
    }
}
