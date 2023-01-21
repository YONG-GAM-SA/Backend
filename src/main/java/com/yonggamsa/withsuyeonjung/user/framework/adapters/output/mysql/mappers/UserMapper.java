package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;

public class UserMapper {

    public static UserData toMySQL(User user) {
        return UserData.builder()
                .id(user.getId())
                .userName(UserNameMapper.toMySQL(user.getUserName()))
                .email(EmailMapper.toMySQL(user.getEmail()))
                .nickname(NicknameMapper.toMySQL(user.getNickname()))
                .birthDate(BirthDateMapper.toMySQL(user.getBirthDate()))
                .build();
    }

    public static User toDomain(UserData user) {
        return User.builder()
                .id(user.getId())
                .userName(UserNameMapper.toDomain(user.getUserName()))
                .email(EmailMapper.toDomain(user.getEmail()))
                .nickname(NicknameMapper.toDomain(user.getNickname()))
                .birthDate(BirthDateMapper.toDomain(user.getBirthDate()))
                .build();
    }
}
