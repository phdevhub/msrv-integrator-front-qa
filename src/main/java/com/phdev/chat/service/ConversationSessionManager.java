package com.phdev.chat.service;

import com.phdev.chat.dto.SessionData;

public interface ConversationSessionManager {

    SessionData createSession(String sessionId);

    SessionData updateSession(SessionData session);

    void clearSession(String sessionId);
}
