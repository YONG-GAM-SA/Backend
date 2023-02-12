package com.yonggamsa.withsuyeonjung.chat.domain.entity.factory;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;

import java.time.ZonedDateTime;

public class ChatFactory {

    public static Chat getchat(String chatId,
                               String chatroomId,
                               String type,
                               String sender,
                               String message,
                               String receiver,
                               ZonedDateTime createdDate
                               ) {
        return Chat.builder()
                .chatid(chatId)
                .chatroomId(chatroomId)
                .type(type)
                .sender(sender)
                .message(message)
                .receiver(receiver)
                .createdDate(createdDate.toString())
                .build();
    }

}
