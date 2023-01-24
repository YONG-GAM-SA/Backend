package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Password {

    private String password;

    public static Password createEncryptedPassword(String password, PasswordEncoder passwordEncoder){
        return new Password(passwordEncoder.encode(password));
    }

}
