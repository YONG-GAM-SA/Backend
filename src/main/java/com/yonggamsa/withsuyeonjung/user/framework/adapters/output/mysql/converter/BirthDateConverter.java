package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.converter;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.BirthDateData;

import javax.persistence.AttributeConverter;

public class BirthDateConverter implements AttributeConverter<BirthDateData, String> {

    @Override
    public String convertToDatabaseColumn(BirthDateData attribute) {
        if(attribute == null) return null;
        return attribute.getYear() + "-" + attribute.getMonth() + "-" + attribute.getDay();
    }

    @Override
    public BirthDateData convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        String[] dates = dbData.split("-");
        return BirthDateData.builder()
                .year(dates[0])
                .month(dates[1])
                .day(dates[2])
                .build();
    }
}
