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
@Component
@RequiredArgsConstructor
public class ChatManagementInputPort implements ChatManagementUseCase {

    private final ChatManagementOutputPort chatManagementOutputPort;

    @Override
    public Chat saveChat(Id id,
                         String sender,
                         String message,
                         ZonedDateTime createdDate) {
        Chat chat = ChatFactory.getchat(id, sender, message, createdDate);
        chatManagementOutputPort.persistChat(chat);
        return null;
    }
}
