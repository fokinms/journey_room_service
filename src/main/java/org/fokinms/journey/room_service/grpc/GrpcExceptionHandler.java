package org.fokinms.journey.room_service.grpc;

import io.grpc.Status;
import io.grpc.StatusException;
import org.springframework.stereotype.Component;

@Component
public class GrpcExceptionHandler implements org.springframework.grpc.server.exception.GrpcExceptionHandler {
    @Override
    public StatusException handleException(Throwable exception) {
        return new StatusException(Status.INTERNAL
                .withDescription("Internal server error")
                .withCause(exception));
    }
}