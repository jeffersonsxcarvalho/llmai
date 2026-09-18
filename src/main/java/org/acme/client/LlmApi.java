package org.acme.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.LlmMessage;
import org.acme.dto.LlmRequest;
import org.acme.dto.LlmResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/chat")
@RegisterRestClient(configKey = "llm-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface LlmApi {

    @POST
    LlmResponse chat(LlmRequest request);
}
