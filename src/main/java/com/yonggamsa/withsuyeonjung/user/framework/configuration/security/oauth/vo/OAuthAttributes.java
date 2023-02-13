package com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.vo;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.application.util.NicknameUtil;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.BirthDateData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.NicknameData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.BirthDateMapper;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.EmailMapper;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.NicknameMapper;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.UserNameMapper;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Getter
public class OAuthAttributes{

    private String userName;
    private EmailData email;
    private String nameAttributeKey;
    private Map<String, Object> attributes;

    private Collection<? extends GrantedAuthority> authorities;

    public String getId(){
        return (String) attributes.get("sub");
    }

    @Builder
    public OAuthAttributes(String userName,
                           EmailData email,
                           String nameAttributeKey,
                           Map<String, Object> attributes,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.email = email;
        this.nameAttributeKey = nameAttributeKey;
        this.attributes = attributes;
        this.authorities = authorities;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes of(String userNameAttributeName, Map<String, Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){

        EmailData email = EmailMapper.toMySQLFromString((String)attributes.get("email"));

        return OAuthAttributes.builder()
                .userName((String)attributes.get("name"))
                .email(email)
                .nameAttributeKey(userNameAttributeName)
                .attributes(attributes)
                .build();
    }

    public User toDomainEntity(){
        return User.builder()
                .id(UUID.randomUUID())
                .email(EmailMapper.toDomain(email))
                .userName(UserNameMapper.toDomainFromString(userName))
                .birthDate(BirthDateMapper.toDomain(new BirthDateData("0000", "00", "00")))
                .nickname(NicknameMapper.toDomain(new NicknameData(NicknameUtil.createRandomNickname())))
                .build();
    }

}
