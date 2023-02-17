package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.repository;

import com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.data.ChatData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatManagementRepository extends MongoRepository<ChatData, String> {
    List<ChatData> findByChatroomId(String chatroomId);

    List<ChatData> findBySender(String sender);

    List<ChatData> findByReceiver(String receiver);
}
