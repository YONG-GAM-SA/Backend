package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.Builder;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "users")
@Entity
@Builder
public class UserData {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    @Embedded
    private EmailData email;
    @Embedded
    private TokenData token; // social_token (OAuth2.0)
    @Embedded
    private NicknameData nickname;
    @Embedded
    private PasswordData password;
    @Embedded
    private BirthDateData birthDate;

}
