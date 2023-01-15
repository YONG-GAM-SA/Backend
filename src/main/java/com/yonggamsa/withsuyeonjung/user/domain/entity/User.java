package com.yonggamsa.withsuyeonjung.user.domain.entity;

import com.yonggamsa.withsuyeonjung.user.domain.vo.*;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class User extends BaseVO {

    private UUID id;
    private Email email;
    private Token token; // social_token (OAuth2.0)
    private UserName userName;
    private Nickname nickname;
    private Password password;
    private BirthDate birthDate;

}
