package com.yonggamsa.withsuyeonjung.user.domain.entity;

import com.yonggamsa.withsuyeonjung.user.domain.vo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseVO {

    private UUID id;
    private Email email;
    private UserName userName;
    private Nickname nickname;
    private Password password;
    private BirthDate birthDate;

}
