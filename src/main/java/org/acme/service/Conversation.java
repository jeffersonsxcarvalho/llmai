package org.acme.service;

import org.acme.dto.LlmMessage;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private final List<LlmMessage> messages = new ArrayList<>();

    public void addMessage(LlmMessage message) {
        messages.add(message);
    }

    public List<LlmMessage> getMessages() {
        return List.copyOf(messages);
    }
}
