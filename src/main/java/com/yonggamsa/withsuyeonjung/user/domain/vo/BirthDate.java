package com.yonggamsa.withsuyeonjung.user.domain.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@Getter
@NoArgsConstructor
public class BirthDate {

    private String year;
    private String month;
    private String day;

    @Builder
    public BirthDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
