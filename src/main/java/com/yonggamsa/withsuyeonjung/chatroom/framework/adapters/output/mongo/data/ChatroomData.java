package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Document(collation = "chatroom")
@Getter
@NoArgsConstructor
public class ChatroomData {
    @Id
    private IDData id;
    private UserListData userListData;
    private ChatMessageData chatMessageData;
    private DateData dateData;

}
