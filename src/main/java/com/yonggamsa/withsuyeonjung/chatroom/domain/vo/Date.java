package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Date {
    private final LocalDateTime createDate;
    private final LocalDateTime deletedDate;

    public Date(LocalDateTime createDate, LocalDateTime createDate1, LocalDateTime deletedDate) {
        this.createDate = createDate1;
        this.deletedDate = deletedDate;
    }
}
