package com.yonggamsa.withsuyeonjung.chat.domain.entity.factory;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;

import java.time.ZonedDateTime;

public class ChatFactory {

    public static Chat getchat(Id id,
                               String sender,
                               String message,
                               ZonedDateTime createdDate
                               ) {
        return Chat.builder()
                .chatId(Id.withoutId())
                .sender(sender)
                .message(message)
                .createdDate(createdDate)
                .build();
    }
}
