package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "users")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
//    @Embedded
    private String email;
    @Embedded
    private TokenData token; // social_token (OAuth2.0)
    @Embedded
    private NicknameData nickname;
    @Embedded
    private PasswordData password;
    @Embedded
    private BirthDateData birthDate;

    public UserData update(String name, String email){
        this.name = name;
        this.email = email;
        return this;
    }

}
