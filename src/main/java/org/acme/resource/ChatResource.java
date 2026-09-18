package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.ChatRequest;
import org.acme.dto.ChatResponse;
import org.acme.service.ChatService;
import org.acme.service.ConversationService;

import java.awt.*;

@Path("/chat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChatResource {

    @Inject
    ChatService chatService;

    @Inject
    ConversationService conversationService;

    @POST
    @Path("/conversation")
    public Long createConversation() {
        return conversationService.createConversation();
    }

    @POST
    @Path("/{conversationId}")
    public ChatResponse chat(
            @PathParam("conversationId") Long conversationId,
            ChatRequest request
    ) {
        return chatService.chat(conversationId, request);
    }
}
