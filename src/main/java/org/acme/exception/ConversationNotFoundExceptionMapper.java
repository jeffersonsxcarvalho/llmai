package org.acme.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class ConversationNotFoundExceptionMapper implements ExceptionMapper<ConversationNotFoundException> {

    @Override
    public Response toResponse(ConversationNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Map.of(
                        "error", exception.getMessage()
                )).build();
    }
}
