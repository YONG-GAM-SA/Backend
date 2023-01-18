package com.yonggamsa.withsuyeonjung.user.application.ports.output;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;

import java.util.UUID;

public interface UserRegisterOutputPort {

    boolean createUser(User user);

}
