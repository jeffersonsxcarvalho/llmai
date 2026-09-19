package org.acme.entity;


import jakarta.persistence.*;

@Entity
@Table(name="message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    public ConversationEntity conversation;

    @Column(nullable = false)
    public String role;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String content;

    @Column(nullable = false)
    public Long sequence;

    public MessageEntity(){}
}
