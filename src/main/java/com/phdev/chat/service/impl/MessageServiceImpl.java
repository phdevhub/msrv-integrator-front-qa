package com.phdev.chat.service.impl;

import com.phdev.chat.dto.SessionData;
import com.phdev.chat.dto.Message;
import com.phdev.chat.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {

    /**
     *
     */
    @Override
    public Message sendMessage(Message message) {
        var sessionData = manageConversationSession(message.sessionId(), message.userId());
        assert sessionData != null;
        return Message.builder()
                .sessionId(sessionData.sessionId())
                .messageId("00000000")
                .userId("00000000")
                .content("hello user ["+sessionData.userName()+"] mock response message")
                .build();
    }

    /**
     *
     */
    private SessionData manageConversationSession(String sessionId, final String userName) {
        if (Objects.isNull(sessionId)) {
            sessionId = "00000000";
        }
        return SessionData.builder()
                .sessionId(sessionId)
                .userName(userName)
                .build();
    }
}
