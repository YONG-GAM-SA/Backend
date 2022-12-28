package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.Value;

@Value
public class BirthDate {

    String birthDate;

    public static BirthDate getBirthDate(String birthDate) {

        return new BirthDate(birthDate);
    }
}
