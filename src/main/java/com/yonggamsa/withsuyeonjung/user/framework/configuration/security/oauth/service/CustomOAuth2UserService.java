package com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.service;

import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.EmailMapper;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.UserMapper;
import com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.vo.OAuthAttributes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService {

    private final UserManagementUseCase userManagementUseCase;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes oAuthAttributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        UserData user = saveOrUpdate(oAuthAttributes);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("TEST")),
                oAuthAttributes.getAttributes(),
                oAuthAttributes.getNameAttributeKey());
    }

    private UserData saveOrUpdate(OAuthAttributes attributes){

        Optional<User> user = userManagementUseCase.findUserByEmail(EmailMapper.toDomain(attributes.getEmail()));
        User savedUser = user.orElseGet(() -> userManagementUseCase.register(attributes.toDomainEntity()));

        return UserMapper.toMySQL(savedUser);
    }

}
