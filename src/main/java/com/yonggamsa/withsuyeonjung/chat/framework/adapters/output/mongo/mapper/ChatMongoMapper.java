package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.mapper;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.data.ChatData;

import java.time.format.DateTimeFormatter;

public class ChatMongoMapper {

    public static Chat chatroomDataToDomain(ChatData chatData) {
        return Chat.builder()
                .chatid(chatData.getChatid())
                .chatroomId(chatData.getChatroomId())
                .type(chatData.getType())
                .sender(chatData.getSender())
                .message(chatData.getMessage())
                .receiver(chatData.getReceiver())
                .createdDate(chatData.getCreatedDate().toString())
                .build();
    }

    public static ChatData chatDomainToData(Chat chat) {
        return ChatData.builder()
                .chatroomId(chat.getChatroomId())
                .type(chat.getType())
                .sender(chat.getSender())
                .message(chat.getMessage())
                .receiver(chat.getReceiver())
                .createdDate(chat.getCreatedDate().toString())
                .build();

    }
}
