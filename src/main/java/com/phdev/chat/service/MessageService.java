package com.phdev.chat.service;

import com.phdev.chat.dto.Message;

public interface MessageService {

    Message sendMessage(Message message);
}
