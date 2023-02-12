package com.yonggamsa.withsuyeonjung.chat.application.ports.input;

import com.yonggamsa.withsuyeonjung.chat.application.ports.output.ChatManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.entity.factory.ChatFactory;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatManagementInputPort implements ChatManagementUseCase {

    private final ChatManagementOutputPort chatManagementOutputPort;

    @Override
    public Chat saveChat(String chatId,
                         String chatroomId,
                         String type,
                         String sender,
                         String message,
                         String receiver,
                         ZonedDateTime createdDate) {
        Chat chat = ChatFactory.getchat(chatId, chatroomId, type, sender, message, receiver, createdDate);
        return chatManagementOutputPort.persistChat(chat);
    }

    @Override
    public List<Chat> retrieveChatBySender(String sender) {
        return chatManagementOutputPort.retrieveChatBySender(sender);
    }

    @Override
    public List<Chat> retrieveChatByReceiver(String receiver) {
        return chatManagementOutputPort.retrieveChatByReceiver(receiver);
    }

    @Override
    public List<Chat> retrieveChatByChatroomId(String chatroomId) {
        return chatManagementOutputPort.retrieveChatByChatroomId(chatroomId);
    }

    @Override
    public List<Chat> retrieveChatList() {
        return chatManagementOutputPort.retrieveChatList();
    }
}
