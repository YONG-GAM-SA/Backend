package com.yonggamsa.withsuyeonjung.chatroom.domain.entity;

import com.google.gson.Gson;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {
    private Id id;
    private static UserList userList;
    private ChatMessage chatMessage;
    private Date date;

    /**
     * 채팅방 생성
     * @Name 윤병찬
     * @param id
     * @return Chatroom
     */
    public static Chatroom createChatroom(Id id) {
        // TODO: id 채번 정책 논의 필요
        if(id == null){
            id = null;
            return null;
        } else {
            Chatroom chatroom = new Chatroom();
            chatroom.id = id;
            return chatroom;
        }
    }


    /**
     * 채널에 접속한 모든 session(유저)에게 chatMessage를 전송
     * chatMessage의 MessageType에 따라 입장, 퇴장, 일반 메세지로 분류되어 처리
     * @param session
     * @param chatMessage
     * @throws Exception
     */
    public void handleMessage(WebSocketSession session, ChatMessage chatMessage) throws Exception {
        if (chatMessage.getType() == MessageType.OPEN) {
            userList.addUser(session, chatMessage.getSender());
            chatMessage.setMessage("알림:" + chatMessage.getSender() + " 님이 입장하셨습니다.");
        } else if (chatMessage.getType() == MessageType.CLOSE) {
            userList.removeUser(session);
            chatMessage.setMessage("알림:" + chatMessage.getSender() + " 님이 퇴장하셨습니다.");
        } else {
            chatMessage.setMessage(chatMessage.getMessage());
        }
        send(chatMessage);
    }

    /**
     * 채널의 모든 세션에게 message 전송
     * @param chatMessage
     * @throws Exception
     */
    private void send(ChatMessage chatMessage) throws Exception {
        Gson gson = new Gson();
        TextMessage textMessage = new TextMessage(gson.toJson(chatMessage));
        for (WebSocketSession session : userList.getUsers().keySet()) {
            if (session.isOpen()) {
                session.sendMessage(textMessage);
            }
        }
    }

    /**
     * 해당 세션을 사용중인 유저명을 반환합니다.
     * @param session
     * @return user
     */
    public String getNicknameBySession (WebSocketSession session) {
        return userList.getUsers().get(session);
    }

    /**
     * 채널에 연결된 모든 세션을 반환합니다.
     * @return
     * 연결된 세션(유저)가 없으면 null, 1 이상이면 모든 session
     */
    public List<WebSocketSession> getAllSessions () {
        if (userList.getUsers() == null || userList.getUsers().isEmpty()) {
            return null;
        }
        return (ArrayList)userList.getUsers().keys();
    }

    /**
     * 채널에 접속중인 모든 사용자들의 닉네임을 반환합니다.
     * @return
     * 사용자 닉네임
     */
    public ArrayList<String> getAllNicknames () {
        return new ArrayList<>(userList.getUsers().values());
    }

    /**
     * 채팅방에 세션(유저) 추가
     * @Name 윤병찬
     * @param session
     * @param nickname
     */
    public void addSession (WebSocketSession session, String nickname) {
        userList.addUser(session, nickname);
    }

    /**
     * 채팅방에서 세션(유저)제외
     * @Name 윤병찬
     * @param session
     */
    public void removeSession (WebSocketSession session) {
        userList.removeUser(session);
    }
}
