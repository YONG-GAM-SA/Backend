package com.yonggamsa.withsuyeonjung.user.framework.adapters.input.rest.request;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRes {

    private UUID id;
    private UserNameData userName;
    private EmailData email;
    private NicknameData nickname;
    private BirthDateData birthDate;

    public static UserRes from(UserData userData) {
        return UserRes.builder()
                .id(userData.getId())
                .userName(userData.getUserName())
                .nickname(userData.getNickname())
                .birthDate(userData.getBirthDate())
                .build();
    }

}
