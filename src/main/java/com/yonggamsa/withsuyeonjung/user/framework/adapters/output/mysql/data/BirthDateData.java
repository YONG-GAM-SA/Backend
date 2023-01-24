package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
public class BirthDateData {

    private String year;
    private String month;
    private String day;

    @Builder
    public BirthDateData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
