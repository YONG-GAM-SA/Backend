package com.yonggamsa.withsuyeonjung.chatroom.domain.entity;

import lombok.*;
import org.springframework.web.socket.WebSocketSession;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Chatroom {
    String chatroomId;
    List<String> users;
    String createdDate;

    public static Chatroom createChatroom(String chatroomId) {
        return Chatroom.builder()
                .chatroomId(chatroomId)
                .users(new ArrayList<>())
                .createdDate(ZonedDateTime.now().toString())
                .build();
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void remove(String user) {
        users.remove(user);
    }
}
