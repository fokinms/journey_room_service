package org.fokinms.journey.room_service.exception;

import java.util.NoSuchElementException;

public class RoomNotFoundException extends NoSuchElementException {
    public RoomNotFoundException(String message) {
        super(message);
    }
}
