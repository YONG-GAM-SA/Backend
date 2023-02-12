package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo;

import com.yonggamsa.withsuyeonjung.chatroom.application.ports.output.ChatroomManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.mapper.ChatroomMongoMapper;
import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.repository.ChatroomManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChatroomManagementMongoDBAdapter implements ChatroomManagementOutputPort {
    private final ChatroomManagementRepository chatroomManagementRepository;

    @Override
    public Chatroom persistChatroom(Chatroom chatroom) {
        return ChatroomMongoMapper.chatroomDataToDomain(chatroomManagementRepository.save(ChatroomMongoMapper.chatroomDomainToData(chatroom)));
    }

    @Override
    public List<Chatroom> retrieveChatroomList() {
        return chatroomManagementRepository.findAll()
                .stream()
                .map(chatroomData -> ChatroomMongoMapper.chatroomDataToDomain(chatroomData))
                .collect(Collectors.toList());
    }

    @Override
    public Chatroom retrieveChatroom(String chatroomId) {
        return ChatroomMongoMapper.chatroomDataToDomain(chatroomManagementRepository.findById(chatroomId).get());
    }

}
