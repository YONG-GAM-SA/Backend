package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output;

import com.yonggamsa.withsuyeonjung.chat.application.ports.output.ChatManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chat.domain.entity.Chat;
import com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.data.ChatData;
import com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.mapper.ChatMongoMapper;
import com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.repository.ChatManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

import static com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.mapper.ChatMongoMapper.chatDomainToData;


@Controller
@RequiredArgsConstructor
public class ChatManagementMongoDBAdapter implements ChatManagementOutputPort {

    private final ChatManagementRepository chatManagementRepository;

    @Override
    public Chat persistChat(Chat chat) {
        return ChatMongoMapper.chatroomDataToDomain(chatManagementRepository.save(chatDomainToData(chat)));
    }

    @Override
    public List<Chat> retrieveChatList() {
        return chatManagementRepository.findAll()
                .stream()
                .map(chatData -> ChatMongoMapper.chatroomDataToDomain(chatData))
                .collect(Collectors.toList());
    }

    @Override
    public List<Chat> retrieveChatByChatroomId(String chatroomId) {
        return chatManagementRepository.findByChatroomId(chatroomId)
                .stream()
                .map(chatData -> ChatMongoMapper.chatroomDataToDomain(chatData))
                .collect(Collectors.toList());
    }

    @Override
    public List<Chat> retrieveChatByReceiver(String receiver) {
        return chatManagementRepository.findByReceiver(receiver)
                .stream()
                .map(chatData -> ChatMongoMapper.chatroomDataToDomain(chatData))
                .collect(Collectors.toList());
    }

    @Override
    public List<Chat> retrieveChatBySender(String sender) {
        return chatManagementRepository.findBySender(sender)
                .stream()
                .map(chatData -> ChatMongoMapper.chatroomDataToDomain(chatData))
                .collect(Collectors.toList());
    }

}
