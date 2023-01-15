package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;

public class UserMapper {

    public static UserData userDomainToUserData(User user) {
//        return null;
        return UserData.builder()
                .id(user.getId())
                .build();
//                .email(new EmailData(user.getEmail()));
    }
}
