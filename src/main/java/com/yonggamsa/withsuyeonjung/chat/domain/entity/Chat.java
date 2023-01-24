package com.yonggamsa.withsuyeonjung.chat.domain.entity;

import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Chat {
    private Id chatId;
    private String chatroomId;
    private String sender;
    private String message;
    private ZonedDateTime createdDate;
}
