package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordData {

    private String password;

}
