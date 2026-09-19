package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.ConversationEntity;

@ApplicationScoped
public class ConversationRepository implements PanacheRepository<ConversationEntity> {


    public ConversationEntity save(ConversationEntity conversation) {
        persist(conversation);
        return conversation;
    }
}
