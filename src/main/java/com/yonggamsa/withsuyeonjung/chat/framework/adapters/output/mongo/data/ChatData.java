package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output.mongo.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@Document(collection = "chat")
public class ChatData {
    @Id
    String chatid;
    String chatroomId;
    String type;
    String sender;
    String message;
    String receiver;
    String createdDate;
}
