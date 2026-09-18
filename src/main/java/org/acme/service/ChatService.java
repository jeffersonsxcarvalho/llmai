package org.acme.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.client.LlmClient;
import org.acme.dto.*;
import org.acme.entity.ConversationEntity;
import org.acme.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ChatService {

    @Inject
    LlmClient llmClient;

    @Inject
    ConversationService conversationService;

    @Inject
    MessageService messageService;

    public ChatResponse chat(Long conversationId, ChatRequest request) {

        ConversationEntity conversation =
                conversationService.getConversation(conversationId);

        String systemPrompt = """
                Você é um assistente de programação especializado em Matemática.

                Responda de forma clara e didática.
                Não invente informações.
                Se não tiver informação suficiente, diga que não sabe.
                """;

        Long nextSequence =
                MessageEntity
                        .find("conversation.id", conversation.id)
                        .count() + 1;

        MessageEntity userMessage = new MessageEntity();

        userMessage.conversation = conversation;
        userMessage.role = "user";
        userMessage.content = request.message;
        userMessage.sequence = nextSequence;

        messageService.saveMessage(userMessage);

        List<MessageEntity> messageEntities =
                MessageEntity
                        .find(
                                "conversation.id = ?1 order by sequence",
                                conversation.id
                        )
                        .list();

        List<LlmMessage> messages = new ArrayList<>();

        messages.add(new LlmMessage("System", systemPrompt));

        for (MessageEntity entity : messageEntities){
            messages.add(
                    new LlmMessage(
                            entity.role,
                            entity.content
                    )
            );
        }




        LlmRequest llmRequest = new LlmRequest(
                "llama3.2:3b",
                messages,
                false
        );

        String response = llmClient.send(llmRequest);

        MessageEntity assistantMessage = new MessageEntity();

        assistantMessage.conversation = conversation;
        assistantMessage.role = "assistant";
        assistantMessage.content = response;
        assistantMessage.sequence = nextSequence + 1;

        messageService.saveMessage(assistantMessage);

        return new ChatResponse(response);
    }
}
