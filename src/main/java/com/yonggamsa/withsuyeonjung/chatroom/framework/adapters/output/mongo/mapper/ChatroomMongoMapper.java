package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.mapper;


import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.data.ChatroomData;

public class ChatroomMongoMapper {

    public static ChatroomData chatroomDomainToData(Chatroom chatroom) {
        return ChatroomData.builder()
                .chatroomId(chatroom.getChatroomId())
                .users(chatroom.getUsers())
                .createdDate(chatroom.getCreatedDate().toString())
                .build();
    }

    public static Chatroom chatroomDataToDomain(ChatroomData chatroomData) {
        return Chatroom.builder()
                .chatroomId(chatroomData.getChatroomId())
                .users(chatroomData.getUsers())
                .createdDate(chatroomData.getCreatedDate().toString())
                .build();
    }

}
