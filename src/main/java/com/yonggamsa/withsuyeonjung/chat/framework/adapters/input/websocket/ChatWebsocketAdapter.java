package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket;

import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket.request.SendChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.ZonedDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatWebsocketAdapter {
    //TODO : Messaging 관련 인터페이스, 구현체 분석
    private final SimpMessagingTemplate simpleMessagingTemplate;
    private final ChatManagementUseCase chatManagementUseCase;


    // publication URL : /pub/chat/room/{chatroomId}/message
    // subscription URL : /topic/chatroom/{chatroomId}
    @MessageMapping("/chat/room/{chatroomId}/message")
    public void sendMessage(@DestinationVariable String chatroomId, SendChatMessage sendChatMessage) {
        // TODO: 프론트 단에서 chatroomId를 페이로드로 보내줄 지 sessionId pathvariable로 인식할 지 결정 필요
        // TODO: 프론트 단에서 payload에 채팅 생성 날짜 입력해서 보내줄 지 결정 필요 -> DB에는 데이터 생성 일자와 채팅 작성일자 별도로 관리해야하는 지도 결정해야 함
        Chat savedChat = chatManagementUseCase.saveChat(
                null,
                chatroomId,
                sendChatMessage.getType(),
                sendChatMessage.getSender(),
                sendChatMessage.getMessage(),
                sendChatMessage.getReceiver(),
                ZonedDateTime.now());

        log.info(String.valueOf(savedChat));
        simpleMessagingTemplate.convertAndSend("/topic/chatroom/" + chatroomId, savedChat);
    }


}
