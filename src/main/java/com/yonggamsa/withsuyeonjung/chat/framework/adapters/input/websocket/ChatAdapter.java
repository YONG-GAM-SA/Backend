package com.yonggamsa.withsuyeonjung.chat.framework.adapters.input.websocket;

import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
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
    private final ChatManagementUseCase chatManagementUseCase;

    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/room/{chatroomId}/message"
    @MessageMapping("/chat/room/{chatroomId}/message")
    public void sendMessage(@DestinationVariable String chatroomId, Chat chat) {

        // TODO: 프론트 단에서 chatroomId를 페이로드로 보내줄 지 sessionId pathvariable로 인식할 지 결정 필요
        chat.setChatroomId(chatroomId);
        // TODO: 프론트 단에서 payload에 채팅 생성 날짜 입력해서 보내줄 지 결정 필요 -> DB에는 데이터 생성 일자와 채팅 작성일자 별도로 관리해야하는 지도 결정해야 함
        chat.setCreatedDate(ZonedDateTime.now(ZoneId.of("Asia/Seoul")));

        com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat saveChat = chatManagementUseCase.saveChat(null, chat.getSender(), chat.getMessage(), chat.getCreatedDate());

        simpleMessagingTemplate.convertAndSend("/topic/chat/room/" + chat.getChatroomId(), saveChat);
    }
}
