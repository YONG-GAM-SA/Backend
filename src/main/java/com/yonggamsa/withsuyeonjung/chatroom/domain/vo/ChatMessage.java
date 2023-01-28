package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatMessage {
    private MessageType type;
    private String sender;
    @Setter
    private String message;
}
