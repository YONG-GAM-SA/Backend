package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.vo.UserName;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserNameData;

public class UserNameMapper {

    public static UserNameData toMySQL(UserName userName){
        return UserNameData.builder()
                .userName(userName.getUserName())
                .build();
    }

    public static UserName toDomain(UserNameData userNameData){
        return UserName.builder()
                .userName(userNameData.getUserName())
                .build();
    }

    public static UserName toDomainFromString(String userName){
        return UserName.builder()
                .userName(userName)
                .build();
    }
}
