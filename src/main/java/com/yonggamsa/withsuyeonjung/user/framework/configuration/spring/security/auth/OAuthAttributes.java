package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.auth;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
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
    private String nameAttributeKey;
    private Map<String, Object> attributes;

    @Builder
    public OAuthAttributes(String name, String email, String nameAttributeKey, Map<String, Object> attributes) {
        this.name = name;
        this.email = email;
        this.nameAttributeKey = nameAttributeKey;
        this.attributes = attributes;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attirbutes){
        return ofGoogle(userNameAttributeName, attirbutes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .nameAttributeKey(userNameAttributeName)
                .attributes(attributes)
                .build();
    }

    // TODO: password, birthdate, token 상의 필요
    public User toDomainEntity(){
        return User.builder()
                .id(UUID.randomUUID())
                .email(null)
                .userName(null)
                .birthDate(null)
                .token(null)
                .nickname(new Nickname(NicknamUtil.createRandomNickname()))
                .build();
    }

}
