package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.input.rest;

import com.yonggamsa.withsuyeonjung.chatroom.application.usecase.ChatroomManagementUseCase;
import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.input.rest.request.CreateChatroom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatrooms")
@RequiredArgsConstructor
@Slf4j
public class ChatroomRestAdapter {

    private final ChatroomManagementUseCase chatroomManagementUseCase;

    @PostMapping("/")
    public Chatroom createChatroom(@RequestBody CreateChatroom createChatroom) {
        log.info(createChatroom.toString());
        return chatroomManagementUseCase.createChatroom(createChatroom.getChatroomId());
    }

    @GetMapping("")
    public List<Chatroom> retrieveChatroomList() {
        return chatroomManagementUseCase.retrieveChatroomList();
    }

    @DeleteMapping("/{chatroomId}/user/{user}")
    public Chatroom exitChatroom(@PathVariable String chatroomId, @PathVariable String user) {
        return chatroomManagementUseCase.exitChatroom(chatroomId, user);
    }

    @PutMapping("/{chatroomId}/user/{user}")
    public Chatroom enterChatroom(@PathVariable String chatroomId, @PathVariable String user) {
        return chatroomManagementUseCase.enterChatroom(chatroomId, user);
    }

}

