package com.yonggamsa.withsuyeonjung.chatroom.application.usecase;

import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatroomManagementUseCase {
    Chatroom createChatroom(String chatroomId);
    List<Chatroom> retrieveChatroomList();

    Chatroom enterChatroom(String chatroomId, String user);

    Chatroom exitChatroom(String chatroomId, String user);
}
