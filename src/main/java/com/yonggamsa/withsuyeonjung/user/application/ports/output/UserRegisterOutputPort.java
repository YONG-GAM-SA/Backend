package com.yonggamsa.withsuyeonjung.user.application.ports.output;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;

public interface UserRegisterOutputPort {

    boolean createUser(User user);
}
