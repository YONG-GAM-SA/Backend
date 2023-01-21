package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.converter;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;

import javax.persistence.AttributeConverter;

public class EmailConverter implements AttributeConverter<EmailData, String> {

    @Override
    public String convertToDatabaseColumn(EmailData attribute) {
        if(attribute == null) return null;
        return attribute.getHostName() + "@" + attribute.getDomainName();
    }

    @Override
    public EmailData convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        String[] names = dbData.split("@");
        return EmailData.builder()
                .hostName(names[0])
                .domainName(names[1])
                .build();
    }
}
