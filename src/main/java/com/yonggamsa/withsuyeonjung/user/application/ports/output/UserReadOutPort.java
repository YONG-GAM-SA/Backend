package com.yonggamsa.withsuyeonjung.user.application.ports.output;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.vo.Email;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;

import java.util.Optional;
import java.util.UUID;

public interface UserReadOutPort {
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(Email email);
}
