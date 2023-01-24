package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.vo.Nickname;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.NicknameData;

public class NicknameMapper {

    public static NicknameData toMySQL(Nickname nickname){
        return NicknameData.builder()
                .nickname(nickname.getNickname())
                .build();
    }

    public static Nickname toDomain(NicknameData nicknameData){
        return Nickname.builder()
                .nickname(nicknameData.getNickname())
                .build();
    }


}
