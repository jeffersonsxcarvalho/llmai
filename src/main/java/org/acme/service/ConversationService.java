package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.ConversationEntity;
import org.acme.exception.ConversationNotFoundException;
import org.acme.repository.ConversationRepository;

@ApplicationScoped
public class ConversationService {

    @Inject
    ConversationRepository conversationRepository;

    @Transactional
    public Long createConversation() {
        ConversationEntity conversation = new ConversationEntity();

        conversationRepository.save(conversation);

        return conversation.id;
    }

    public ConversationEntity getConversation(Long id) {

        ConversationEntity conversation =
                conversationRepository.findById(id);

        if(conversation == null) {
            throw new ConversationNotFoundException(id);
        }

        return conversation;
    }
}
