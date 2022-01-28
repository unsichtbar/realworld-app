package org.acme.application;

import org.acme.domain.Message;

import io.smallrye.mutiny.Uni;

public interface Handler<ReturnType, MessageType extends Message<ReturnType>> {

    Uni<ReturnType> handle(MessageType message);
    
}
