package com.yonggamsa.withsuyeonjung.user.application.ports.input;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.entity.factory.UserFactory;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserManagementInputPort implements UserManagementUseCase {

    private final UserRegisterOutputPort userRegisterOutputPort;

    @Override
    public User registerUser(Email email,
                             Token token,
                             UserName userName,
                             Nickname nickname,
                             Password password,
                             BirthDate birthDate) {

        User user = UserFactory.getUser(
                email,
                token,
                userName,
                nickname,
                password,
                birthDate);

        return userRegisterOutputPort.createUser(user) ? user : null;
    }
}
