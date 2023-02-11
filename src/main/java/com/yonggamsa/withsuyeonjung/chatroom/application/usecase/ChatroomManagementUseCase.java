package com.yonggamsa.withsuyeonjung.chatroom.application.usecase;

import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.Id;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface ChatroomManagementUseCase {
    Chatroom createChatroom(Id id);
    List<Chatroom> retrieveChatroomList();

    Chatroom enterChatroom(Id id, WebSocketSession session, String user);

    Chatroom exitChatroom(Id id, WebSocketSession session, String user);
}
