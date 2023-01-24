package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.mappers;

import com.yonggamsa.withsuyeonjung.user.domain.vo.Email;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;

public class EmailMapper {

    public static Email toDomain(EmailData emailData){
        return Email.builder()
                .hostName(emailData.getHostName())
                .domainName(emailData.getDomainName())
                .build();
    }

    public static EmailData toMySQL(Email email){
        return EmailData.builder()
                .hostName(email.getHostName())
                .domainName(email.getDomainName())
                .build();
    }

    public static EmailData toMySQLFromString(String email){
        String[] data = email.split("@");
        return EmailData.builder()
                .domainName(data[0])
                .hostName(data[1])
                .build();
    }

}
