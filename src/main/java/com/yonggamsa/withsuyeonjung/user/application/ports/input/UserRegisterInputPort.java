package com.yonggamsa.withsuyeonjung.user.application.ports.input;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.application.usecase.UserRegisterUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;

public class UserRegisterInputPort implements UserRegisterUseCase {

    private final UserRegisterOutputPort userRegisterOutputPort;

    public UserRegisterInputPort(UserRegisterOutputPort userRegisterOutputPort) {
        this.userRegisterOutputPort = userRegisterOutputPort;
    }

    @Override
    public User registerUser(User user) {

        return userRegisterOutputPort.createUser(user) ? user : null;
    }
}
