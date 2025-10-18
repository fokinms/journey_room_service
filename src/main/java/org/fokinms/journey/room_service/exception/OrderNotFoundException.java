package org.fokinms.journey.room_service.exception;

import java.util.NoSuchElementException;

public class OrderNotFoundException extends NoSuchElementException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
