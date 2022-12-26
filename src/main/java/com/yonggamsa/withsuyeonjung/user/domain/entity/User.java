package com.yonggamsa.withsuyeonjung.user.domain.entity;

import com.yonggamsa.withsuyeonjung.user.domain.vo.*;

import java.util.UUID;

public class User extends BaseVO {

    private UUID id;
    private Email email;
    private Token token; // social_token (OAuth2.0)
    private UserName name;
    private Nickname nickname;
    private Password password;
    private BirthDate birthDate;



}
