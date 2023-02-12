package com.yonggamsa.withsuyeonjung.chatroom.application.ports.input;

import com.yonggamsa.withsuyeonjung.chatroom.application.ports.output.ChatroomManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chatroom.application.usecase.ChatroomManagementUseCase;
import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatroomManagementInputPort implements ChatroomManagementUseCase {

    private final ChatroomManagementOutputPort chatroomManagementOutputPort;

    @Override
    public Chatroom createChatroom(String chatroomId) {
        Chatroom chatroom = Chatroom.createChatroom(chatroomId);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }

    @Override
    public List<Chatroom> retrieveChatroomList() {
        return chatroomManagementOutputPort.retrieveChatroomList();
    }

    @Override
    public Chatroom enterChatroom(String chatroomId, String user) {
        Chatroom chatroom = chatroomManagementOutputPort.retrieveChatroom(chatroomId);
        chatroom.addUser(user);
        chatroomManagementOutputPort.persistChatroom(chatroom);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }

    @Override
    public Chatroom exitChatroom(String chatroomId, String user) {
        Chatroom chatroom = chatroomManagementOutputPort.retrieveChatroom(chatroomId);
        chatroom.remove(user);
        return chatroomManagementOutputPort.persistChatroom(chatroom);
    }
}
