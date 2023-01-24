package com.yonggamsa.withsuyeonjung.user.framework.adapters.input.rest.request;

import lombok.Data;

@Data
public class AddUser {

    private String email;
    private String token; // social_token (OAuth2.0)
    private String userName;
    private String nickname;
    private String password;
    private String birthDate;

}
