package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class UserNameData {

    private String userName;

    @Builder
    public UserNameData(String userName) {
        this.userName = userName;
    }
}
