package com.coding.lovable_clone.entity;

import com.coding.lovable_clone.MessageRole;

import java.time.Instant;

public class ChatMessage {
    Long id;
    ChatSession chatSession;

    String content;

    MessageRole role;

    String toolCalls; // JSON Array of Tools Called

    Integer tokensUsed;

    Instant createdAt;
}
