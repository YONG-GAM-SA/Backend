package com.yonggamsa.withsuyeonjung.user.framework.adapters.output;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.UserJpaRepository;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@RequiredArgsConstructor
public class UserMySQLAdapter implements UserRegisterOutputPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean createUser(User user) {
        UserData userData = UserMapper.userDomainToUserData(user);
        userJpaRepository.save(userData);
        // TODO: 구현해야됩니다,,
        return false;
    }
}
