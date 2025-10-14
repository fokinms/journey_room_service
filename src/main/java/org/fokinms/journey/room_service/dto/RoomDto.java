package org.fokinms.journey.room_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RoomDto(Long id,
                      String apartmentName,
                      String city,
                      byte numberOfRooms,
                      BigDecimal price,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
}