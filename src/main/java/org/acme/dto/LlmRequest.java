package org.acme.dto;

import java.util.List;

public class LlmRequest {

    public String model;
    public List<LlmMessage> messages;

    public LlmRequest() {

    }

    public LlmRequest(String model, List<LlmMessage> messages) {
        this.model = model;
        this.messages = messages;
    }
}
