package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.acme.service.Conversation;

@Entity
@Table(name="message")
public class MessageEntity extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    public ConversationEntity conversation;

    @Column(nullable = false)
    public String role;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String content;

    @Column(nullable = false)
    public Long sequence;
}
