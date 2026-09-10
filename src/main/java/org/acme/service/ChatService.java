package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.client.LlmClient;
import org.acme.dto.*;

import java.util.List;

@ApplicationScoped
public class ChatService {

    @Inject
    LlmClient llmClient;

    public ChatResponse chat(ChatRequest request) {

        String systemPrompt = """
                Você é um assistente de programação especializado em Java.

                Responda de forma clara e didática.
                Não invente informações.
                Se não tiver informação suficiente, diga que não sabe.
                """;

        LlmRequest llmRequest = new LlmRequest(
                "nosso-modelo",
                List.of(
                        new LlmMessage("system", systemPrompt),
                        new LlmMessage("user", request.message)
                )
        );

        String response = llmClient.send(llmRequest);

        return new ChatResponse(response);
    }
}
