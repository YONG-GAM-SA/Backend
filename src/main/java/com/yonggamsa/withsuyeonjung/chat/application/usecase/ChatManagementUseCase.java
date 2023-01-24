package com.yonggamsa.withsuyeonjung.chat.application.usecase;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public interface ChatManagementUseCase {
    Chat saveChat(Id id,
                  String sender,
                  String message,
                  ZonedDateTime createdDate);
}
