package com.yonggamsa.withsuyeonjung.chatroom.application.ports.output;

import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatroomManagementOutputPort {
    Chatroom persistChatroom(Chatroom chatroom);
    List<Chatroom> retrieveChatroomList();
    Chatroom retrieveChatroom(Id id);
}
