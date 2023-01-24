package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.vo.Password;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.PasswordData;

public class PasswordMapper {

    public static PasswordData toMySQL(Password password){
        return new PasswordData(password.getPassword());
    }

    public static Password toDomain(PasswordData passwordData){
        return new Password(passwordData.getPassword());
    }

}
