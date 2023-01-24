package com.yonggamsa.withsuyeonjung.user.application.usecase;

import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;

import java.util.Optional;
import java.util.UUID;

public interface UserManagementUseCase {

    public User registerUser(Email email, Token to0ken,UserName userName,Nickname nickname,Password password, BirthDate birthDate);

    public User register(User user);

    public Optional<User> findUserById(UUID id);
    public Optional<User> findUserByEmail(Email email);

}
