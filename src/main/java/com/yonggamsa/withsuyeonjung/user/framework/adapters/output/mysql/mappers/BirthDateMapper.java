package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.vo.BirthDate;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.BirthDateData;

public class BirthDateMapper {

    public static BirthDateData toMySQL(BirthDate birthDate){
        return BirthDateData.builder()
                .year(birthDate.getYear())
                .month(birthDate.getMonth())
                .day(birthDate.getDay())
                .build();
    }

    public static BirthDate toDomain(BirthDateData birthDate){
        return BirthDate.builder()
                .year(birthDate.getYear())
                .month(birthDate.getMonth())
                .day(birthDate.getDay())
                .build();
    }

//    public static BirthDate toDomainFromString(String birthDate){
//
//    }

}
