package com.phdev.chat.dto;

import lombok.Builder;

@Builder
public record Message(
        String sessionId,
        String messageId,
        String userId,
        String content) {
}
