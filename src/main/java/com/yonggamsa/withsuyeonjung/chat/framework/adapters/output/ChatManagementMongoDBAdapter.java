package com.yonggamsa.withsuyeonjung.chat.framework.adapters.output;

import com.yonggamsa.withsuyeonjung.chat.application.usecase.ChatManagementUseCase;
import com.yonggamsa.withsuyeonjung.chatroom.application.ports.output.ChatroomManagementOutputPort;
import com.yonggamsa.withsuyeonjung.chatroom.domain.entity.Chatroom;
import com.yonggamsa.withsuyeonjung.chatroom.domain.vo.Id;
import com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.output.mongo.repository.ChatroomManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ChatManagementMongoDBAdapter {

}
