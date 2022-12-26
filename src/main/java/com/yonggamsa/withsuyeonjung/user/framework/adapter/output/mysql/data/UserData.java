package com.yonggamsa.withsuyeonjung.user.framework.adapter.output.mysql.data;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "users")
@Entity
public class UserData {

    @Id
    private UUID id;
    @Embedded
    private EmailData email;
    @Embedded
    private TokenData token; // social_token (OAuth2.0)
    @Embedded
    private UsernameData name;
    @Embedded
    private NicknameData nickname;
    @Embedded
    private PasswordData password;
    @Embedded
    private BirthDateData birthDate;

}
