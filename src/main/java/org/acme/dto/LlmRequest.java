package org.acme.dto;

import java.util.List;

public class LlmRequest {

    public String model;
    public List<LlmMessage> messages;
    public boolean stream;

    public LlmRequest() {

    }

    public LlmRequest(String model, List<LlmMessage> messages, boolean stream) {
        this.model = model;
        this.messages = messages;
        this.stream = stream;
    }
}
