package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.repository;

import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.data.ChatroomData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomManagementRepository extends MongoRepository<ChatroomData, String> {

}
