package org.acme.client;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.LlmRequest;
import org.acme.dto.LlmResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class LlmClient {

    private final LlmApi llmApi;

    public LlmClient(@RestClient LlmApi llmApi) {
        this.llmApi = llmApi;
    }

    public String send(LlmRequest request) {
        // aqui vamos conversar com a LLM

        LlmResponse response = llmApi.chat(request);

        return response.response;
    }


}
