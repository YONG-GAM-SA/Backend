package com.yonggamsa.withsuyeonjung.user.framework.adapters.input;

import com.yonggamsa.withsuyeonjung.user.application.usecase.UserManagementUseCase;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.input.rest.request.UserRes;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers.UserMapper;
import com.yonggamsa.withsuyeonjung.user.framework.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class RestAdapter {

    private final UserManagementUseCase userManagementUseCase;

    @GetMapping("/{userId}")
    public ResponseEntity<UserRes> getUserInfoByUserId(@PathVariable String userId){
        UUID uuid = UUID.fromString(userId);
        UserData userById = UserMapper.toMySQL(userManagementUseCase.findUserById(uuid).orElseThrow(UserNotFoundException::new));
        return ResponseEntity.ok(UserRes.from(userById));
    }
}
