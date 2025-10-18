package org.fokinms.journey.room_service.dto;

import org.fokinms.journey.room_service.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDto(Long id,
                       Long userId,
                       Long roomId,
                       OrderStatus orderStatus,
                       BigDecimal orderPrice,
                       LocalDateTime orderStartDate,
                       LocalDateTime orderEndDate,
                       LocalDateTime createdAt,
                       LocalDateTime updatedAt) {
}
