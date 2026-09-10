package org.acme.dto;

public class LlmMessage {

    public String role;
    public String content;

    public LlmMessage() {

    }

    public LlmMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
