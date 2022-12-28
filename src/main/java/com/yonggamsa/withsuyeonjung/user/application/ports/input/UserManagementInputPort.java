package com.yonggamsa.withsuyeonjung.user.application.ports.input;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.entity.factory.UserFactory;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;


public class UserManagementInputPort implements UserManagementUseCase {

    private final UserRegisterOutputPort userRegisterOutputPort;

    public UserManagementInputPort(UserRegisterOutputPort userRegisterOutputPort) {
        this.userRegisterOutputPort = userRegisterOutputPort;
    }

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
