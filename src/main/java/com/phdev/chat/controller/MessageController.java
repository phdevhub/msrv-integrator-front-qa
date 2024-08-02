package com.phdev.chat.controller;

import com.phdev.chat.dto.Message;
import com.phdev.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversation")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<Object> message(@RequestBody final Message body) {
        var returnMessage = messageService.sendMessage(body);
        return ResponseEntity
                .accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .body(returnMessage);
    }
}
