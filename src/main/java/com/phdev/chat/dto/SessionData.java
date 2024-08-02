package com.phdev.chat.dto;

import lombok.Builder;

@Builder
public record SessionData(
        String sessionId,
        String userName,
        String state) {
}
