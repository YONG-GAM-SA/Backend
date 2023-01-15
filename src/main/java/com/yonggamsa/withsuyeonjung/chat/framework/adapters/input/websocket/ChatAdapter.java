package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket;

import com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket.request.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
@RequiredArgsConstructor
public class ChatAdapter {
    //TODO : Messaging 관련 인터페이스, 구현체 분석
    private final SimpMessagingTemplate simpleMessagingTemplate;

    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"
    @MessageMapping("/chat/room/{chatroomId}/message")
    public void sendMessage(@DestinationVariable String chatroomId, Chat chat) {
        chat.setChatroomId(chatroomId);
        chat.setCreatedDate(ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        simpleMessagingTemplate.convertAndSend("/topic/chat/room/" + chat.getChatroomId(), chat);
    }
}
