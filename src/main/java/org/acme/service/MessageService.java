package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entity.ConversationEntity;
import org.acme.entity.MessageEntity;
import org.acme.exception.ConversationNotFoundException;

@ApplicationScoped
public class MessageService {

    @Transactional
    public void saveMessage(MessageEntity message) {
        message.persist();
    }
}
