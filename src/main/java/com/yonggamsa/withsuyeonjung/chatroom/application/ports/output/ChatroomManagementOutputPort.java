package com.yonggamsa.withsuyeonjung.chatroom.application.ports.output;

import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChatroomManagementOutputPort {
    Chatroom persistChatroom(Chatroom chatroom);
    List<Chatroom> retrieveChatroomList();
    Chatroom retrieveChatroom(String chatroomId);
}
