package com.phdev.chat.controller;

import com.phdev.chat.service.MessageService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // create mockmvc bean for injection
@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private MessageService messageService;
    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    void setup() {

    }

    @Test
    void test_messageNotNull_shouldReturnMessage() throws Exception {
        MvcResult response;
        response = this.mockMvc
            .perform(MockMvcRequestBuilders
                    .post("/api/conversation/message")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "userId":"22222222",
                            "content":"test message"
                        }"""))
            .andExpect(MockMvcResultMatchers.status().is(202))
            .andReturn();

        BDDAssertions.then(response).isNotNull();
    }

    @Test
    void test_messageNull_shouldReturnBadRequest() throws Exception {
        var response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/conversation/message").contentType(
                        MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400)).andReturn();
    }


}
