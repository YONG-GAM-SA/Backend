package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import com.yonggamsa.withsuyeonjung.user.domain.vo.Nickname;
import com.yonggamsa.withsuyeonjung.user.framework.NicknamUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NicknameData {

    private String nickname;

    public static NicknameData createNicknameRandomly(){
        return NicknameData.builder()
                .nickname(NicknamUtil.createRandomNickname())
                .build();
    }
}
