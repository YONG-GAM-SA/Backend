package com.yonggamsa.withsuyeonjung.user.framework.adapters.output;

import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserReadOutPort;
import com.yonggamsa.withsuyeonjung.user.application.ports.output.UserRegisterOutputPort;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.vo.Email;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.UserJpaRepository;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMySQLAdapter implements UserRegisterOutputPort, UserReadOutPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean createUser(User user) {
        UserData userData = UserMapper.userDomainToUserData(user);
        userJpaRepository.save(userData);
        // TODO: 구현해야됩니다,,
        return false;
    }

    @Override
    public Optional<User> findById(UUID id) {
        UserData findUser = userJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 ID의 유저입니다. : " + id.toString()));
        return null;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        UserData user = userJpaRepository.findByEmail(email.getEmail());
        return Optional.empty();
    }
}
