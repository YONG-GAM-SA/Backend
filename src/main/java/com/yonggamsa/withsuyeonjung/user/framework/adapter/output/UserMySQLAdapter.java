package com.yonggamsa.withsuyeonjung.user.framework.adapter.output;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.framework.adapter.output.mysql.UserJpaRepository;
import com.yonggamsa.withsuyeonjung.user.framework.adapter.output.mysql.data.UserData;
import com.yonggamsa.withsuyeonjung.user.framework.adapter.output.mysql.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.annotation.ApplicationScope;

@RequiredArgsConstructor
@ApplicationScope
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
