package com.phdev.chat.service.impl;

import com.phdev.chat.dto.Message;
import com.phdev.chat.service.ConversationSessionManager;
import com.phdev.chat.service.MessageService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MessageServiceImplTest {

    @Mock
    private ConversationSessionManager conversationSessionManager;

    @InjectMocks
    private MessageService messageService = new MessageServiceImpl();

    @BeforeEach
    void setup() {
    }

    @Test
    // @MockitoSettings(strictness = Strictness.LENIENT) reduce warnings and exceptions
    void test_sendMessage_shouldReturnMessage() {
        // ArgumentCaptor<?> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Message message = Message.builder().content("test").build();

        /*
         given(conversationSessionManager.createSession(any(String.class)))
                 .willReturn(SessionData.builder().build());
        */

        Message returnMessage = messageService.sendMessage(message);

        // BDDMockito.then(conversationSessionManager).should(times(1)).createSession();
        BDDAssertions.then(returnMessage).isNotNull();
    }
}
