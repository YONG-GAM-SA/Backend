package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class UserList {
    private ConcurrentHashMap<WebSocketSession, String> users = new ConcurrentHashMap<>();

    /**
     * 유저 목록에 유저 추가
     * @Name 윤병찬
     * @param webSocketSession
     * @param user
     */
    public void addUser(WebSocketSession webSocketSession, String user) {
        users.put(webSocketSession, user);
    }

    /**
     * 유저 목록에서 유저 제외
     * @Name 윤병찬
     * @param webSocketSession
     */
    public void removeUser(WebSocketSession webSocketSession) {
        users.remove(webSocketSession);
    }

    /**
     * 세션으로 유저 조회
     * @Name 윤병찬
     * @param webSocketSession
     */
    public String retrieveUser(WebSocketSession webSocketSession) {
        return users.get(webSocketSession);
    }

}
