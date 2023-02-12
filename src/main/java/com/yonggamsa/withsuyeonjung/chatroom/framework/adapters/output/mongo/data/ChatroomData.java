package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Document(collection = "chatroom")
public class ChatroomData {
    @Id
    String chatroomId;
    List<String> users;
    String createdDate;

}
