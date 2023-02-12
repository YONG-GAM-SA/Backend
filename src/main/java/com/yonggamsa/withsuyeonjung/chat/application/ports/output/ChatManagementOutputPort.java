package com.yonggamsa.withsuyeonjung.chat.application.ports.output;


import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ChatManagementOutputPort {
    Chat persistChat(Chat chat);

    List<Chat> retrieveChatList();

    List<Chat> retrieveChatByChatroomId(String chatroomId);

    List<Chat> retrieveChatByReceiver(String receiver);

    List<Chat> retrieveChatBySender(String sender);
}
