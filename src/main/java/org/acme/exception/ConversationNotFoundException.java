package org.acme.exception;

public class ConversationNotFoundException extends RuntimeException{
    public ConversationNotFoundException(Long conversationId) {
        super("Conversa não encontrada: " + conversationId);
    }
}
