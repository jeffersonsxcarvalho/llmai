package org.acme.dto;

public class LlmResponse {
    public String model;
    public String created_at;
    public LlmMessage message;
    public boolean done;
    public String done_reason;
}
