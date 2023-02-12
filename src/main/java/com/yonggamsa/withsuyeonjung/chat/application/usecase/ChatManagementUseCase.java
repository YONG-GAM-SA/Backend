package com.yonggamsa.withsuyeonjung.chat.application.usecase;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public interface ChatManagementUseCase {
    Chat saveChat(String chatId,
                  String chatroomId,
                  String type,
                  String sender,
                  String message,
                  String receiver,
                  ZonedDateTime createdDate);

    List<Chat> retrieveChatBySender(String sender);

    List<Chat> retrieveChatByReceiver(String receiver);

    List<Chat> retrieveChatByChatroomId(String chatroomId);

    List<Chat> retrieveChatList();
}
