package com.yonggamsa.withsuyeonjung.user.framework.adapters.input;

import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.entity.User;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.input.rest.request.AddUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yonggamsa.withsuyeonjung.user.domain.vo.Email.getEmail;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RestAdapter {

    private final UserManagementUseCase userManagementUseCase;

    @PostMapping("/register")
    public void registerUser(@RequestBody AddUser addUser) {



        userManagementUseCase.registerUser(
                Email.getEmail(addUser.getEmail()),
                Token.getToken(addUser.getToken()),
                UserName.getUserName(addUser.getUserName()),
                Nickname.getNickName(addUser.getNickname()),
                Password.getPassword(addUser.getPassword()),
                BirthDate.getBirthDate(addUser.getBirthDate()));
    }

}
