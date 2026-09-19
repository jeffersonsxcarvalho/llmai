package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entity.MessageEntity;

import java.util.List;

@ApplicationScoped
public class MessageRepository implements PanacheRepository<MessageEntity> {

    @Transactional
    public void save(MessageEntity message) {
        persist(message);
    }


    public List<MessageEntity> findByConversation(Long conversationId) {
        return find(
                "conversation.id = ?1 order by sequence",
                conversationId
                )
                .list();
    }

    public long countByConversation(Long conversationId) {
        return find("conversation.id", conversationId)
                .count();
    }
}
