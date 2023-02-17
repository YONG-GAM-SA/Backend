package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.rest;

import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatRestAdapter {

    private final ChatManagementUseCase chatManagementUseCase;

    //TODO: Response DTO 만들기
    @GetMapping("/sender/{sender}")
    public List<Chat> retrieveChatBySender(String sender) {
        return chatManagementUseCase.retrieveChatBySender(sender);
    }

    @GetMapping("/receiver/{receiver}")
    public List<Chat> retrieveChatByReceiver(String receiver) {
        return chatManagementUseCase.retrieveChatByReceiver(receiver);
    }

    @GetMapping("/chatroomId/{chatroomId}")
    public List<Chat> retrieveChatByChatroomId(String chatroomId) {
        return chatManagementUseCase.retrieveChatByChatroomId(chatroomId);
    }

    @GetMapping("")
    public List<Chat> retrieveChatList() {
        return chatManagementUseCase.retrieveChatList();
    }

}

