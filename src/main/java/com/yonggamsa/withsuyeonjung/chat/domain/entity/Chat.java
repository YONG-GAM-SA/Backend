package com.yonggamsa.withsuyeonjung.chat.domain.entity;

import com.yonggamsa.withsuyeonjung.chat.domain.vo.Id;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Chat {
    String chatid;
    String chatroomId;
    String type;
    String sender;
    String message;
    String receiver;
    String createdDate;
}
