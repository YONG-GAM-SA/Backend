package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import com.yonggamsa.withsuyeonjung.user.framework.NicknameUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class NicknameData {

    private String nickname;

    @Builder
    public NicknameData(String nickname) {
        this.nickname = nickname;
    }

    public static NicknameData createNicknameRandomly(){
        return NicknameData.builder()
                .nickname(NicknameUtil.createRandomNickname())
                .build();
    }
}
