package com.yonggamsa.withsuyeonjung.chat.application.usecase;

import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;

import java.time.ZonedDateTime;

public interface ChatManagementUseCase {
    Chat saveChat(Id id,
                  String sender,
                  String message,
                  ZonedDateTime createdDate);
}
