package com.yonggamsa.withsuyeonjung.chatroom.application.ports.input;

import com.yonggamsa.withsuyeonjung.chat.application.ports.input.ChatManagementInputPort;
import com.yonggamsa.withsuyeonjung.chatroom.application.ports.output.ChatroomManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chatroom.application.usecase.ChatroomManagementUseCase;
import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.ChatMessage;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.Date;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.Id;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.UserList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@RequiredArgsConstructor
public class ChatroomManagementInputPort implements ChatroomManagementUseCase {

    private final ChatroomManagementOutputPort chatroomManagementOutputPort;

    @Override
    public Chatroom createChatroom(Id id) {
        Chatroom chatroom = Chatroom.createChatroom(id);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }

    @Override
    public List<Chatroom> retrieveChatroomList() {
        return chatroomManagementOutputPort.retrieveChatroomList();
    }

    @Override
    public Chatroom enterChatroom(Id id, WebSocketSession session, String user) {
        Chatroom chatroom = chatroomManagementOutputPort.retrieveChatroom(id);
        chatroom.addSession(session, user);
        chatroomManagementOutputPort.persistChatroom(chatroom);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }

    @Override
    public Chatroom exitChatroom(Id id, WebSocketSession session, String user) {
        Chatroom chatroom = chatroomManagementOutputPort.retrieveChatroom(id);
        chatroom.removeSession(session);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }
}
