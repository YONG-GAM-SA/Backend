package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.auth;

import com.yonggamsa.withsuyeonjung.user.domain.vo.Nickname;
import com.yonggamsa.withsuyeonjung.user.framework.NicknamUtil;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.NicknameData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class OAuthAttributes {

    private String name;
    private String email;
    private Map<String, Object> attributes;

    @Builder
    public OAuthAttributes(String name, String email, Map<String, Object> attributes) {
        this.name = name;
        this.email = email;
        this.attributes = attributes;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttribtute, Map<String, Object> attirbutes){
        return ofGoogle(userNameAttribtute, attirbutes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributes, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .attributes(attributes)
                .build();
    }

    // TODO: password, birthdate, token 상의 필요
    public UserData toJpaUserEntity(){
        return UserData.builder()
                .id(UUID.randomUUID())
                .email(new EmailData(this.email))
                .name(this.name)
                .nickname(NicknameData.createNicknameRandomly())
                .build();
    }

}
