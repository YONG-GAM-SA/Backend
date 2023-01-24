package com.yonggamsa.withsuyeonjung.user.domain.vo;

import lombok.*;

@Getter
@NoArgsConstructor
public class Email {

    private String hostName;
    private String domainName;

    @Builder
    public Email(String hostName, String domainName) {
        this.hostName = hostName;
        this.domainName = domainName;
    }
}
