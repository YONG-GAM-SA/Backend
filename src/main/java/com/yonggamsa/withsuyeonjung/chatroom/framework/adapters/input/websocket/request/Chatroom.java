package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket.request;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Chatroom {
    private String chatroomId;
    private String sender;
    private String message;
    private ZonedDateTime createdDate;
}
