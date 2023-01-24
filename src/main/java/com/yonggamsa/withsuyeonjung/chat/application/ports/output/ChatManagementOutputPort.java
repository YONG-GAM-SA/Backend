package com.yonggamsa.withsuyeonjung.chat.application.ports.output;


import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import org.springframework.stereotype.Service;

@Service
public interface ChatManagementOutputPort {
    Chat persistChat(Chat chat);
}
