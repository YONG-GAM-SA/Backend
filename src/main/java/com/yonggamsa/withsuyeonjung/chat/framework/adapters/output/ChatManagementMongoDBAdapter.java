package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output;

import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
import org.springframework.stereotype.Controller;

@Controller
public class ChatManagementMongoDBAdapter{
    ChatManagementUseCase chatManagementUseCase;
    public ChatManagementMongoDBAdapter(ChatManagementUseCase chatManagementUseCase){
        this.chatManagementUseCase = chatManagementUseCase;
    }
}
