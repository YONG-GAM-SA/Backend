package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket.request;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class SendChatMessage {
    String type;
    String sender;
    String message;
    String receiver;
}
