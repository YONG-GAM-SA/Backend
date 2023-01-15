package com.yonggamsa.withsuyeonjung.user.framework.adapters.input;

import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.domain.vo.*;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.input.rest.request.AddUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RestAdapter {

    private final UserManagementUseCase userManagementUseCase;


}
