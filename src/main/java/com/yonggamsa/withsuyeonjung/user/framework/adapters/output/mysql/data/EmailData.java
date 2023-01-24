package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
public class EmailData {

    private String hostName;
    private String domainName;

    @Builder
    public EmailData(String hostName, String domainName) {
        this.hostName = hostName;
        this.domainName = domainName;
    }
}
