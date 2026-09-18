package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entity.ConversationEntity;
import org.acme.exception.ConversationNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ConversationService {

    @Transactional
    public Long createConversation() {
        ConversationEntity conversation = new ConversationEntity();

        conversation.persist();

        return conversation.id;
    }

    public ConversationEntity getConversation(Long id) {

        ConversationEntity conversation =
                ConversationEntity.findById(id);

        if(conversation == null) {
            throw new ConversationNotFoundException(id);
        }

        return conversation;
    }
}
