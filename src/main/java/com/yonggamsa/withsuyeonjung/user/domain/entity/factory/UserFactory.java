package com.yonggamsa.withsuyeonjung.user.domain.entity.factory;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;

public class UserFactory {

    public static User getUser(Email email,
                               Token token,
                               UserName userName,
                               Nickname nickname,
                               Password password,
                               BirthDate birthDate){

        return User.builder()
                .email(Email.getEmail(email.getEmail()))
                .token(Token.getToken(token.getToken()))
                .userName(UserName.getUserName(userName.getUserName()))
                .nickname(Nickname.getNickName(nickname.getNickName()))
                .password(Password.getPassword(password.getPassword()))
                .birthDate(BirthDate.getBirthDate(birthDate.getBirthDate()))
                .build();
    }
}
