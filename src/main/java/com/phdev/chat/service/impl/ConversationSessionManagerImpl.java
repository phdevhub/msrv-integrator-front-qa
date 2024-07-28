package com.phdev.chat.service.impl;

import com.phdev.chat.dto.SessionData;
import com.phdev.chat.service.ConversationSessionManager;

public class ConversationSessionManagerImpl implements ConversationSessionManager {
    /**
     * @param sessionId
     * @return
     */
    @Override
    public SessionData createSession(final String sessionId) {
        return null;
    }

    /**
     * @param session
     * @return
     */
    @Override
    public SessionData updateSession(final SessionData session) {
        return null;
    }

    /**
     * @param sessionId
     */
    @Override
    public void clearSession(final String sessionId) {

    }
}
