package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Date {
    private LocalDateTime createDate;
    private LocalDateTime deletedDate;

    public Date() {
        this.createDate = LocalDateTime.now();
    }
    public Date(LocalDateTime createDate, LocalDateTime deletedDate) {
        this.createDate = createDate;
        this.deletedDate = deletedDate;
    }
}
